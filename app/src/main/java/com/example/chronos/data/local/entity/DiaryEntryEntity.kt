package com.example.chronos.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary_entries")
data class DiaryEntryEntity(
    @PrimaryKey val id: String,          // ← String id をそのまま主キーにする
    val epochMillis: Long,
    val text: String,
    val moodColorArgb: Int?
)
