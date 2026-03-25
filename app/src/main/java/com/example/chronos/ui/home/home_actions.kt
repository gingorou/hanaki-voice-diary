// home_actions.kt
package com.example.chronos.ui.home

sealed interface HomeAction {
    data object ClickCenter : HomeAction
    data object CancelRecording : HomeAction
    data class PickMood(val idx: Int) : HomeAction
    data object SkipMood : HomeAction
    data class RootSizeChanged(val w: Float, val h: Float) : HomeAction
    data class VaseCenterChanged(val center: androidx.compose.ui.geometry.Offset) : HomeAction
}