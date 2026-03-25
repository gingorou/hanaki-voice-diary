package com.example.chronos.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chronos.data.local.entity.DiaryEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entry: DiaryEntryEntity)

    @Query("UPDATE diary_entries SET moodColorArgb = :moodColor WHERE id = :id")
    suspend fun updateMood(id: String, moodColor: Int?)

    @Query("SELECT * FROM diary_entries ORDER BY epochMillis DESC")
    fun observeAll(): Flow<List<DiaryEntryEntity>>
}
