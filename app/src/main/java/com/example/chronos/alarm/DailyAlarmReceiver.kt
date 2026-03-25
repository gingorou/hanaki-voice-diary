package com.example.chronos.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first
import com.example.chronos.notify.DiaryNotification

//ここは設定した時刻に通知を発生させるファイル
class DailyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("DailyAlarmReceiver", "onReceive action=${intent.action}")

        // 通知を表示
        DiaryNotification.show(context)

        // 非同期処理（次回アラーム再登録）
        val pending = goAsync()
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val enabled = AlarmPrefs.enabledFlow(context).first()
                Log.d("DailyAlarmReceiver", "enabled=$enabled")

                if (enabled) {
                    val h = AlarmPrefs.hourFlow(context).first()
                    val m = AlarmPrefs.minuteFlow(context).first()
                    Log.d("DailyAlarmReceiver", "scheduleNext h=$h m=$m")
                    DailyAlarmScheduler.scheduleNext(context, h, m)
                } else {
                    Log.d("DailyAlarmReceiver", "alarm disabled, skip reschedule")
                }
            } catch (e: Exception) {
                Log.e("DailyAlarmReceiver", "error in onReceive", e)
            } finally {
                pending.finish()
            }
        }
    }
}
