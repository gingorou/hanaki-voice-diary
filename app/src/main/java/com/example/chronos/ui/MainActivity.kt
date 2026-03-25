package com.example.chronos.ui

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chronos.alarm.AlarmPrefs
import com.example.chronos.alarm.DailyAlarmScheduler
import com.example.chronos.repository.AudioRepository
import com.example.chronos.repository.DiaryRepository
import com.example.chronos.repository.InMemoryDiaryRepository
import com.example.chronos.repository.RecorderRepository
import com.example.chronos.ui.archive.DiaryArchiveScreen
import com.example.chronos.ui.home.VoiceDiaryHomeScreen
import com.example.chronos.viewmodel.AudioViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Calendar
import androidx.compose.ui.platform.LocalContext
import com.example.chronos.MyApp
import com.example.chronos.repository.RoomDiaryRepository

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val ctx = LocalContext.current
                val scope = rememberCoroutineScope()

                val context = LocalContext.current
                val app = context.applicationContext as MyApp

                val diaryRepo: DiaryRepository = remember {
                    RoomDiaryRepository(app.db.diaryEntryDao(), scope)
                }


                /* ---------- 通知チャンネル ---------- */
                LaunchedEffect(Unit) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val channel = NotificationChannel(
                            "diary",
                            "日記通知",
                            NotificationManager.IMPORTANCE_DEFAULT
                        )
                        ctx.getSystemService(NotificationManager::class.java)
                            .createNotificationChannel(channel)
                    }
                }

                /* ---------- 通知権限（Android 13+） ---------- */
                val notifPermissionLauncher =
                    rememberLauncherForActivityResult(
                        ActivityResultContracts.RequestPermission()
                    ) { granted ->
                        Log.d("ALARM_UI", "POST_NOTIFICATIONS granted=$granted")
                    }

                LaunchedEffect(Unit) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        notifPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }

                /* ---------- マイク権限 ---------- */
                var hasMicPermission by remember { mutableStateOf(false) }
                val micPermissionLauncher =
                    rememberLauncherForActivityResult(
                        ActivityResultContracts.RequestPermission()
                    ) { granted -> hasMicPermission = granted }

                LaunchedEffect(Unit) {
                    micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                }

                /* ---------- Repository / ViewModel ---------- */
                val audioRepo = remember { AudioRepository(ctx.contentResolver) }
                val vm = remember { AudioViewModel(audioRepo) }
                val recRepo = remember { RecorderRepository(ctx) }
                val state by vm.uiState.collectAsState()

                /* ---------- Alarm Prefs ---------- */
                val hour by AlarmPrefs.hourFlow(ctx).collectAsState(initial = 23)
                val minute by AlarmPrefs.minuteFlow(ctx).collectAsState(initial = 30)
                val enabled by AlarmPrefs.enabledFlow(ctx).collectAsState(initial = true)

                /* ---------- 初期化：起動時に1回だけスケジュール反映 ---------- */
                var didInit by remember { mutableStateOf(false) }
                LaunchedEffect(Unit) {
                    if (didInit) return@LaunchedEffect
                    didInit = true

                    val en = AlarmPrefs.enabledFlow(ctx).first()
                    val h = AlarmPrefs.hourFlow(ctx).first()
                    val m = AlarmPrefs.minuteFlow(ctx).first()

                    if (en) {
                        DailyAlarmScheduler.cancel(ctx)
                        DailyAlarmScheduler.scheduleNext(ctx, h, m)
                    } else {
                        DailyAlarmScheduler.cancel(ctx)
                    }
                }

                // ✅ Navigation
                val nav = rememberNavController()

                NavHost(navController = nav, startDestination = "home") {

                    composable("home") {
                        var isRecording by remember { mutableStateOf(false) }
                        var recordedUri by remember { mutableStateOf<Uri?>(null) }

                        // ✅ 追加：アーカイブ件数（合計 / 今月 / 先月）を算出
                        val entries = diaryRepo.listEntries()
                        val totalCount = entries.size

                        val calNow = Calendar.getInstance()
                        val nowYear = calNow.get(Calendar.YEAR)
                        val nowMonth = calNow.get(Calendar.MONTH) // 0..11

                        val calLast = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }
                        val lastYear = calLast.get(Calendar.YEAR)
                        val lastMonth = calLast.get(Calendar.MONTH)

                        val thisMonthCount = entries.count { e ->
                            val c = Calendar.getInstance().apply { timeInMillis = e.epochMillis }
                            c.get(Calendar.YEAR) == nowYear && c.get(Calendar.MONTH) == nowMonth
                        }

                        val lastMonthCount = entries.count { e ->
                            val c = Calendar.getInstance().apply { timeInMillis = e.epochMillis }
                            c.get(Calendar.YEAR) == lastYear && c.get(Calendar.MONTH) == lastMonth
                        }


                        VoiceDiaryHomeScreen(
                            hasMicPermission = hasMicPermission,
                            hour = hour,
                            minute = minute,
                            enabled = enabled,
                            isRecording = isRecording,

                            onRequestMicPermission = {
                                micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                            },

                            onToggleEnabled = { next ->
                                scope.launch {
                                    AlarmPrefs.setEnabled(ctx, next)
                                    if (next) {
                                        val h = AlarmPrefs.hourFlow(ctx).first()
                                        val m = AlarmPrefs.minuteFlow(ctx).first()
                                        DailyAlarmScheduler.scheduleNext(ctx, h, m)
                                    } else {
                                        DailyAlarmScheduler.cancel(ctx)
                                    }
                                }
                            },

                            onPickTime = {
                                TimePickerDialog(
                                    ctx,
                                    { _, h, m ->
                                        scope.launch {
                                            AlarmPrefs.save(ctx, h, m)
                                            val en = AlarmPrefs.enabledFlow(ctx).first()
                                            if (en) DailyAlarmScheduler.scheduleNext(ctx, h, m)
                                        }
                                    },
                                    hour,
                                    minute,
                                    true
                                ).show()
                            },

                            onStartRecord = {
                                recordedUri = recRepo.start()
                                isRecording = true
                            },

                            onStopRecord = {
                                recordedUri = recRepo.stop()
                                isRecording = false
                            },

                            onOpenArchive = { nav.navigate("archive") },

                            // ✅ APIは「猶予0秒後」にHome側が呼ぶ
                            onRunGemini = {
                                val uri = recordedUri ?: return@VoiceDiaryHomeScreen
                                vm.run(uri, "audio/mp4")
                            },

                            // ✅ API完了後の文字を保存してIDを返す（色はまだnull）
                            onCommitTranscription = { text ->
                                diaryRepo.addEntry(text, null)
                            },

                            // ✅ 色は後から更新
                            onSetMood = { entryId, moodColorOrNull ->
                                diaryRepo.updateMood(entryId, moodColorOrNull)
                            },

                            // ✅ AudioResult? -> String（transcriptだけ渡す）
                            transcriptionText = state.result?.transcript ?: "",

                            // ✅ ローディング状態
                            geminiLoading = state.loading,

                            onDisposeStopIfNeeded = { recRepo.stopIfNeeded() },

                            // ✅ 追加：吹き出し用の件数を渡す
                            archiveTotalCount = totalCount,
                            archiveThisMonthCount = thisMonthCount,
                            archiveLastMonthCount = lastMonthCount
                        )
                    }

                    composable("archive") {
                        DiaryArchiveScreen(
                            repo = diaryRepo,
                            onBack = { nav.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
