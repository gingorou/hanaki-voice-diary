package com.example.chronos

import kotlinx.serialization.Serializable
//ここは音声結果を持つファイル
@Serializable
data class AudioResult(
    val transcript: String = "",
    val summary: String = ""
)
