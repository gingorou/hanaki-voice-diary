package com.example.chronos.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chronos.repository.AudioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
//ここは音声に関わる機能ファイル
class AudioViewModel(
    private val repo: AudioRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AudioUiState())
    val uiState: StateFlow<AudioUiState> = _uiState

    fun run(uri: Uri, mimeType: String) {
        viewModelScope.launch {
            _uiState.value = AudioUiState(loading = true)

            runCatching { repo.processAudio(uri, mimeType) }
                .onSuccess { result ->
                    _uiState.value = AudioUiState(result = result)
                }
                .onFailure { e ->
                    _uiState.value = AudioUiState(error = e.message ?: "error")
                }
        }
    }
}
val archiveTotalCount = MutableStateFlow(0)
val archiveThisMonthCount = MutableStateFlow(0)
val archiveBeforeThisMonthCount = MutableStateFlow(0)
