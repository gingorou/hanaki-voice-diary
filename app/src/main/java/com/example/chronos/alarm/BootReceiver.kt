package com.example.chronos.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class BootReceiver : BroadcastReceiver() {

    //ここは端末再起動後も設定時刻が保持されるファイル
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("BootReceiver", "onReceive action=${intent.action}")

        if (intent.action != Intent.ACTION_BOOT_COMPLETED) return

        val pending = goAsync()
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val enabled = AlarmPrefs.enabledFlow(context).first()
                Log.d("BootReceiver", "enabled=$enabled")

                if (enabled) {
                    val h = AlarmPrefs.hourFlow(context).first()
                    val m = AlarmPrefs.minuteFlow(context).first()
                    Log.d("BootReceiver", "scheduleNext h=$h m=$m")
                    DailyAlarmScheduler.scheduleNext(context, h, m)
                } else {
                    Log.d("BootReceiver", "disabled -> skip scheduling")
                }
            } catch (e: Exception) {
                Log.e("BootReceiver", "error in onReceive", e)
            } finally {
                pending.finish()
            }
        }
    }
}
