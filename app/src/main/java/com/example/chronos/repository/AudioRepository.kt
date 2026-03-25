package com.example.chronos.repository

import android.content.ContentResolver
import android.net.Uri
import android.util.Log
import com.example.chronos.AudioResult
import com.google.firebase.Firebase
import com.google.firebase.vertexai.vertexAI
import com.google.firebase.vertexai.type.content
import com.google.firebase.vertexai.type.generationConfig
import kotlinx.serialization.json.Json
//ここはAIの結果画面を司るファイル
class AudioRepository(
    private val contentResolver: ContentResolver
) {
    private val json = Json { ignoreUnknownKeys = true }

    // ★ lazy の中は「modelを返す」だけにする
    private val model by lazy {
        Firebase.vertexAI.generativeModel(
            modelName = "gemini-2.5-flash-lite",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
            }
        )
    }

    // ★ これは lazy の外（class直下）
    suspend fun processAudio(uri: Uri, mimeType: String): AudioResult {
        val bytes = contentResolver.openInputStream(uri)?.use { it.readBytes() }
            ?: return AudioResult("文字起こしに失敗しました。", "音声の読み込みに失敗しました。")

        val prompt = content {
            inlineData(bytes, mimeType)
            text(
                "この音声を正確に日本語で文字起こしし、内容を短い1文で日本語で要約してください。" +
                        "出力は必ず以下のJSON形式で: {\"transcript\":\"...\",\"summary\":\"...\"}"
            )
        }

        return runCatching {
            val response = model.generateContent(prompt)
            val raw = response.text ?: "{}"
            json.decodeFromString(AudioResult.serializer(), raw)
        }.getOrElse { e ->
            Log.e("AUDIO_AI", "processAudio failed", e)
            AudioResult("文字起こしに失敗しました。", e.message ?: "処理中にエラーが発生しました。")
        }
    }
}
