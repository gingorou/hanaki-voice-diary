package com.example.chronos.repository

import androidx.compose.runtime.mutableStateListOf
import java.util.Calendar

data class DiaryEntry(
    val id: String,
    val epochMillis: Long,
    val text: String,
    val moodColorArgb: Int?
)

interface DiaryRepository {
    /** 文字起こし完了後に保存。idを返す（後で色を更新するため） */
    fun addEntry(text: String, moodColor: Int? = null): String

    /** F画面で選んだ色を、既存エントリに後から反映 */
    fun updateMood(id: String, moodColor: Int?)

    fun listEntries(): List<DiaryEntry>
}

class InMemoryDiaryRepository : DiaryRepository {
    private val entries = mutableStateListOf<DiaryEntry>()

    override fun addEntry(text: String, moodColor: Int?): String {
        val now = System.currentTimeMillis()
        val id = now.toString()
        entries.add(
            0,
            DiaryEntry(
                id = id,
                epochMillis = now,
                text = text,
                moodColorArgb = moodColor
            )
        )
        return id
    }

    override fun updateMood(id: String, moodColor: Int?) {
        val index = entries.indexOfFirst { it.id == id }
        if (index >= 0) {
            val old = entries[index]
            entries[index] = old.copy(moodColorArgb = moodColor)
        }
    }

    override fun listEntries(): List<DiaryEntry> = entries
}

data class ArchiveCounts(
    val total: Int,
    val thisMonth: Int,
    val beforeThisMonth: Int
)

/** API24 OK版：Calendarで月初を求める */
fun DiaryRepository.getArchiveCounts(): ArchiveCounts {
    val entries = listEntries()

    val cal = Calendar.getInstance().apply {
        set(Calendar.DAY_OF_MONTH, 1)
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
    val startOfThisMonth = cal.timeInMillis

    val total = entries.size
    val thisMonth = entries.count { it.epochMillis >= startOfThisMonth }
    val beforeThisMonth = total - thisMonth

    return ArchiveCounts(
        total = total,
        thisMonth = thisMonth,
        beforeThisMonth = beforeThisMonth
    )
}
