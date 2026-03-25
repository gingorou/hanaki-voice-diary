package com.example.chronos.alarm

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("alarm_prefs")

object AlarmPrefs {

    private val KEY_HOUR = intPreferencesKey("hour")
    private val KEY_MINUTE = intPreferencesKey("minute")
    private val KEY_ENABLED = booleanPreferencesKey("enabled")

    fun hourFlow(ctx: Context) =
        ctx.dataStore.data.map { it[KEY_HOUR] ?: 23 }

    fun minuteFlow(ctx: Context) =
        ctx.dataStore.data.map { it[KEY_MINUTE] ?: 30 }

    fun enabledFlow(ctx: Context) =
        ctx.dataStore.data.map { it[KEY_ENABLED] ?: false }


    suspend fun save(ctx: Context, hour: Int, minute: Int) {
        ctx.dataStore.edit {
            it[KEY_HOUR] = hour
            it[KEY_MINUTE] = minute
        }
    }

    suspend fun setEnabled(ctx: Context, enabled: Boolean) {
        ctx.dataStore.edit {
            it[KEY_ENABLED] = enabled
        }
    }
}
