// home_state.kt
package com.example.chronos.ui.home

import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

enum class Phase {
    A_IDLE,
    B_RECORDING_FILL,
    B_WATERING_DRAIN,
    B_SPARKLE,
    C_PANEL_REVEAL,
    C_COLOR_EXPAND,
    C_PANEL_DISMISS,
    C_ORB_TO_VASE,
    D_STARS,
    D_SUCCESS,
    BACK_TO_A
}

enum class CenterButtonContent { MIC, BARS, DOTS, CHECK }

@Immutable
data class FlowerState(
    val flowerId: String = "lily",
    val vaseId: String = "uekihaci",
    val backgroundRes: Int? = null,
    val depth: Float = 0f
)

@Immutable
data class UiState(
    val phase: Phase = Phase.A_IDLE,

    // サイズ/座標
    val rootW: Float = 0f,
    val rootH: Float = 0f,
    val vaseCenterPx: Offset = Offset.Zero,

    // 録音
    val remainRecord: Int = 30,
    val didStartApi: Boolean = false,

    // 保存
    val savedEntryId: String? = null,
    val didCommit: Boolean = false,

    // 下テキスト
    val bottomText: String = "",
    val bottomTextVisible: Boolean = false,

    // パネル
    val panelVisible: Boolean = false,
    val selectedIndex: Int? = null,
    val selectedArgb: Int? = null,
    val expandOrigin: Offset = Offset.Unspecified,

    // 丸（花瓶に吸い込まれるやつ）
    val orbVisible: Boolean = false,
    val orbColor: Color = Color.White,
    val orbPos: Offset = Offset.Zero,

    // 表示アセット
    val flowerState: FlowerState = FlowerState(),

    // アーカイブ数
    val archiveTotalCount: Int = 0,
    val archiveThisMonthCount: Int = 0,
    val archiveLastMonthCount: Int = 0
)