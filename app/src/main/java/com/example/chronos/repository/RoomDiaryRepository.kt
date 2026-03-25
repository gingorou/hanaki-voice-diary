package com.example.chronos.repository

import com.example.chronos.data.local.dao.DiaryEntryDao
import com.example.chronos.data.local.entity.DiaryEntryEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RoomDiaryRepository(
    private val dao: DiaryEntryDao,
    private val scope: CoroutineScope
) : DiaryRepository {

    private val cache = MutableStateFlow<List<DiaryEntry>>(emptyList())

    init {
        scope.launch(Dispatchers.IO) {
            dao.observeAll().collectLatest { list ->
                cache.value = list.map { e ->
                    DiaryEntry(
                        id = e.id,
                        epochMillis = e.epochMillis,
                        text = e.text,
                        moodColorArgb = e.moodColorArgb
                    )
                }
            }
        }
    }

    override fun addEntry(text: String, moodColor: Int?): String {
        val now = System.currentTimeMillis()
        val id = now.toString()

        scope.launch(Dispatchers.IO) {
            dao.upsert(
                DiaryEntryEntity(
                    id = id,
                    epochMillis = now,
                    text = text,
                    moodColorArgb = moodColor
                )
            )
        }
        return id
    }

    override fun updateMood(id: String, moodColor: Int?) {
        scope.launch(Dispatchers.IO) { dao.updateMood(id, moodColor) }
    }

    override fun listEntries(): List<DiaryEntry> = cache.value
}
