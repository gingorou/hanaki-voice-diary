package com.example.chronos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chronos.data.local.dao.DiaryEntryDao
import com.example.chronos.data.local.entity.DiaryEntryEntity

@Database(
    entities = [DiaryEntryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun diaryEntryDao(): DiaryEntryDao
}
