package com.example.chronos

import android.app.Application
import androidx.room.Room
import com.example.chronos.data.local.AppDatabase

class MyApp : Application() {
    lateinit var db: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "voice_diary.db"
        ).build()
    }
}
