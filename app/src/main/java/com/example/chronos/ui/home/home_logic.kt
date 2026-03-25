// home_logic.kt
package com.example.chronos.ui.home

import androidx.compose.animation.core.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlinx.coroutines.delay
import kotlin.math.hypot
import kotlin.math.min

class VoiceDiaryHomeLogic(
    initial: UiState = UiState()
) {
    val state = mutableStateOf(initial)

    // UIから色一覧を渡す設計でもOKだが、まずはここ固定でいい
    val moodColors = listOf(
        Color(0xFFB39DDB),
        Color(0xFF90CAF9),
        Color(0xFFA5D6A7),
        Color(0xFFFFF59D),
        Color(0xFFFFAB91)
    )

    fun dispatch(action: HomeAction) {
        when (action) {
            is HomeAction.RootSizeChanged -> {
                val s = state.value
                state.value = s.copy(rootW = action.w, rootH = action.h)
            }
            is HomeAction.VaseCenterChanged -> {
                state.value = state.value.copy(vaseCenterPx = action.center)
            }
            HomeAction.CancelRecording -> {
                // UI側で coroutine scope を持って reset() を呼ぶ設計にしてもOK
                // ここは「フラグだけ戻す」でもOK
                state.value = state.value.copy(phase = Phase.A_IDLE)
            }
            HomeAction.ClickCenter -> {
                val s = state.value
                when (s.phase) {
                    Phase.A_IDLE -> startRecording()
                    Phase.B_RECORDING_FILL -> stopToWatering()
                    else -> Unit
                }
            }
            is HomeAction.PickMood -> {
                pickMood(action.idx)
            }
            HomeAction.SkipMood -> {
                skipMood()
            }
        }
    }

    private fun startRecording() {
        val s = state.value
        state.value = s.copy(
            phase = Phase.B_RECORDING_FILL,
            didStartApi = false,
            didCommit = false,
            savedEntryId = null,
        )
    }

    private fun stopToWatering() {
        state.value = state.value.copy(phase = Phase.B_WATERING_DRAIN)
    }

    private fun pickMood(idx: Int) {
        val s = state.value
        val argb = moodColors[idx].toArgb()
        state.value = s.copy(
            selectedIndex = idx,
            selectedArgb = argb,
            expandOrigin = s.expandOrigin, // UI側でセットでもOK
        )
        // ここで「シーケンス開始フラグ」を立てる方式にする（後述）
    }

    private fun skipMood() {
        // 必要なら onSetMood(null) を外部コール
        state.value = state.value.copy(phase = Phase.A_IDLE, panelVisible = false)
    }

    fun maxRadius(): Float {
        val s = state.value
        return hypot(s.rootW, s.rootH).coerceAtLeast(1f)
    }

    // ====== ここが今回の「runAfterPickSequence」相当 ======
    suspend fun runAfterPickSequence(
        orbCenters: List<Offset>,
        onSetMood: (String, Int?) -> Unit
    ) {
        // ここで state を見て進める
        val s0 = state.value
        val idx = s0.selectedIndex ?: 0
        val argb = s0.selectedArgb
        val entryId = s0.savedEntryId
        if (entryId != null) onSetMood(entryId, argb)

        // C_COLOR_EXPAND
        state.value = state.value.copy(phase = Phase.C_COLOR_EXPAND)
        delay(420)

        // C_PANEL_DISMISS
        state.value = state.value.copy(phase = Phase.C_PANEL_DISMISS, panelVisible = false)
        delay(450)

        // C_ORB_TO_VASE
        val s1 = state.value
        val start = orbCenters.getOrNull(idx)
            ?.takeIf { it.isValidOffset() }
            ?: Offset(s1.rootW * 0.5f, s1.rootH * 0.5f)
        val end = if (s1.vaseCenterPx != Offset.Zero) s1.vaseCenterPx else Offset(s1.rootW * 0.5f, s1.rootH * 0.55f)

        state.value = state.value.copy(
            phase = Phase.C_ORB_TO_VASE,
            orbVisible = true,
            orbColor = moodColors.getOrNull(idx) ?: Color.White,
            orbPos = start
        )

        val mid = Offset((start.x + end.x) / 2f, min(start.y, end.y) - s1.rootH * 0.10f)
        val duration = 900
        val steps = 45
        for (i in 0..steps) {
            val t = i / steps.toFloat()
            val pos = quadBezier(start, mid, end, t)
            state.value = state.value.copy(orbPos = pos)
            delay((duration / steps).toLong())
        }

        state.value = state.value.copy(orbVisible = false)

        // D_STARS
        state.value = state.value.copy(phase = Phase.D_STARS)
        delay(900)

        // D_SUCCESS
        state.value = state.value.copy(phase = Phase.D_SUCCESS)
        delay(650)

        // BACK_TO_A
        state.value = state.value.copy(
            phase = Phase.A_IDLE,
            bottomTextVisible = false,
            selectedIndex = null,
            selectedArgb = null
        )
    }
}

// ===== util =====
private fun Offset.isValidOffset(): Boolean =
    this != Offset.Unspecified && this.x.isFinite() && this.y.isFinite()

private fun quadBezier(p0: Offset, p1: Offset, p2: Offset, t: Float): Offset {
    val u = 1f - t
    return (p0 * (u * u)) + (p1 * (2f * u * t)) + (p2 * (t * t))
}
private operator fun Offset.times(s: Float) = Offset(x * s, y * s)
private operator fun Offset.plus(o: Offset) = Offset(x + o.x, y + o.y)