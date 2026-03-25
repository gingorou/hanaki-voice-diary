package com.example.chronos.repository

import android.content.Context
import android.media.MediaRecorder
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

class RecorderRepository(
    private val context: Context
) {
    private var recorder: MediaRecorder? = null
    private var currentFile: File? = null

    fun start(): Uri {
        stopIfNeeded()

        val dir = File(context.filesDir, "records").apply { mkdirs() }
        val file = File(dir, "diary_${System.currentTimeMillis()}.m4a")
        currentFile = file

        val r = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setAudioSamplingRate(44100)
            setAudioEncodingBitRate(128_000)
            setOutputFile(file.absolutePath)
            prepare()
            start()
        }
        recorder = r

        // FileProvider経由のUri（後でRepositoryへ渡す）
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }

    fun stop(): Uri? {
        val file = currentFile ?: return null
        val r = recorder ?: return null

        runCatching { r.stop() }
        runCatching { r.reset() }
        runCatching { r.release() }

        recorder = null
        currentFile = null

        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }

    fun stopIfNeeded() {
        runCatching { recorder?.stop() }
        runCatching { recorder?.release() }
        recorder = null
        currentFile = null
    }
}
