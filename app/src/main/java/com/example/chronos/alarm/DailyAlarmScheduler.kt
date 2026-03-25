package com.example.chronos.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import java.util.Calendar
import java.util.Date
//ここは時刻を設定し、それを保持するファイル
object DailyAlarmScheduler {

    private const val REQ_CODE = 2001
    private const val ACTION_DAILY = "com.example.chronos.alarm.ACTION_DAILY"

    /** 次に来る hour:minute を 1回だけ exact で登録する（時計アプリ方式） */
    fun scheduleNext(context: Context, hour: Int, minute: Int) {
        val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // ★保険：同じPIが残ってると困るので一度キャンセル
        cancel(context)

        val pi = pendingIntent(context)

        val now = System.currentTimeMillis()
        val triggerAt = nextOccurrenceMillis(hour, minute, now)
        val diffMin = (triggerAt - now) / 60_000L

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (am.canScheduleExactAlarms()) {
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAt, pi)
                } else {
                    // exact不可なら“だいたい”で（ただし端末によっては遅延あり得る）
                    am.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAt, pi)
                }
            } else {
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAt, pi)
            }
        } catch (se: SecurityException) {
            Log.e("DailyAlarmScheduler", "SecurityException -> fallback set()", se)
            am.set(AlarmManager.RTC_WAKEUP, triggerAt, pi)
        }

        Log.d(
            "DailyAlarmScheduler",
            "scheduleNext h=$hour m=$minute triggerAt=$triggerAt (${Date(triggerAt)}) now=$now (${Date(now)}) diffMin=$diffMin"
        )
    }


    fun cancel(context: Context) {
        val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.cancel(pendingIntent(context))
        Log.d("DailyAlarmScheduler", "cancel called")
    }

    /** “次に来る”その時刻を必ず未来で返す（23:20→0:30 は明日0:30になる） */
    private fun nextOccurrenceMillis(hour: Int, minute: Int, now: Long): Long {
        val cal = Calendar.getInstance().apply {
            timeInMillis = now
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (cal.timeInMillis <= now) {
            cal.add(Calendar.DAY_OF_YEAR, 1)
        }
        return cal.timeInMillis
    }

    private fun pendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, DailyAlarmReceiver::class.java).apply {
            action = ACTION_DAILY
        }
        return PendingIntent.getBroadcast(
            context,
            REQ_CODE,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
}
