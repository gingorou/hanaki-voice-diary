package com.example.chronos.viewmodel

import com.example.chronos.AudioResult
//ここは音声結果ファイル
data class AudioUiState(
    val loading: Boolean = false,
    val result: AudioResult? = null,
    val error: String? = null
)
