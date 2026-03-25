package com.example.chronos.ui.settings

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    val ctx = androidx.compose.ui.platform.LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("設定") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("戻る") }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                "通知が遅れないように、端末設定を確認してください。",
                style = MaterialTheme.typography.bodyMedium
            )

            NotificationExactAlarmCard(ctx = ctx)

            BatteryOptimizationCard(ctx = ctx)

            Spacer(Modifier.height(24.dp))
        }
    }
}

/* ===============================
   Exact Alarm (Android 12+)
   =============================== */

@Composable
fun NotificationExactAlarmCard(ctx: Context) {
    val am = remember(ctx) {
        ctx.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    var exactOk by remember { mutableStateOf(true) }

    // 設定画面から戻ってきたら再チェック
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                exactOk = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    am.canScheduleExactAlarms()
                } else true
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    // 初回もチェック
    LaunchedEffect(Unit) {
        exactOk = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            am.canScheduleExactAlarms()
        } else true
    }

    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp)) {
            Text("正確な通知（推奨）", style = MaterialTheme.typography.titleMedium)

            Spacer(Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Exact Alarm", modifier = Modifier.weight(1f))
                Text(if (exactOk) "許可済み" else "未許可")
            }

            if (!exactOk && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = {
                        val intent =
                            Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
                                data = Uri.parse("package:${ctx.packageName}")
                            }
                        ctx.startActivity(intent)
                    }
                ) {
                    Text("正確な通知を有効にする")
                }

                Spacer(Modifier.height(6.dp))
                Text(
                    "端末によってはアプリを終了すると通知が遅延/抑制されます。上の設定を有効にしてください。",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

/* ===============================
   Battery Optimization
   =============================== */

@Composable
fun BatteryOptimizationCard(ctx: Context) {
    val pm = remember(ctx) {
        ctx.getSystemService(Context.POWER_SERVICE) as PowerManager
    }

    var ignoring by remember { mutableStateOf(true) }

    // 画面復帰時に再チェック
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val obs = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                ignoring = pm.isIgnoringBatteryOptimizations(ctx.packageName)
            }
        }
        lifecycleOwner.lifecycle.addObserver(obs)
        onDispose { lifecycleOwner.lifecycle.removeObserver(obs) }
    }

    // 初回チェック
    LaunchedEffect(Unit) {
        ignoring = pm.isIgnoringBatteryOptimizations(ctx.packageName)
    }

    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp)) {
            Text("電池最適化（重要）", style = MaterialTheme.typography.titleMedium)

            Spacer(Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("最適化", modifier = Modifier.weight(1f))
                Text(if (ignoring) "解除済み" else "対象")
            }

            if (!ignoring) {
                Spacer(Modifier.height(8.dp))

                Button(
                    onClick = {
                        val intent = Intent(
                            Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                        ).apply {
                            data = Uri.parse("package:${ctx.packageName}")
                        }
                        ctx.startActivity(intent)
                    }
                ) {
                    Text("最適化を解除する")
                }

                Spacer(Modifier.height(6.dp))

                OutlinedButton(
                    onClick = {
                        val intent = Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        ).apply {
                            data = Uri.parse("package:${ctx.packageName}")
                        }
                        ctx.startActivity(intent)
                    }
                ) {
                    Text("アプリ詳細を開く")
                }

                Spacer(Modifier.height(6.dp))
                Text(
                    "端末によっては、電池最適化の対象だと録音/通知が止まりやすくなります。",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
