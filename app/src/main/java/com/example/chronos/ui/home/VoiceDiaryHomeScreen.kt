package com.example.chronos.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.chronos.R
import com.example.chronos.ui.assets.AssetCatalog
import com.example.chronos.ui.theme.KosugiMaru
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.hypot
import kotlin.math.sin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.animation.AnimatedVisibility as AV
import androidx.compose.ui.unit.Dp
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import kotlin.math.*
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import kotlin.math.hypot
import kotlin.math.pow
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.clip
import androidx.compose.animation.core.VectorConverter
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin
import kotlinx.coroutines.Job
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalDensity
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import androidx.compose.foundation.layout.size
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.TransformOrigin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.math.*
import kotlin.random.Random
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.geometry.Size


private const val SPARKLE_EVAP_MS = 520
private const val SPARKLE_BLINK_MS = 900L
@Composable
private fun SparkleBlinkWithEvaporate(
    active: Boolean,          // B_SPARKLE中 true
    evaporate: Boolean,       // 消したい瞬間 true（フラグ推奨）
    centerPx: Offset,
    resA: Int,
    resB: Int,
    modifier: Modifier = Modifier,

    // 点滅
    intervalMs: Long = 240L,
    crossFadeMs: Int = 140,

    // 見た目
    sizeDp: Dp = 340.dp,
    baseDropDp: Dp = 160.dp,  // ＋で下

    // ふっと消える時間
    evapMs: Int = 420,

    // ✅ 任天堂っぽい「ふっ」：縮み
    shrinkTo: Float = 0.88f   // 0.82〜0.92がおすすめ
) {
    val valid = centerPx != Offset.Unspecified && centerPx.x.isFinite() && centerPx.y.isFinite()
    if (!valid) return
    if (!active && !evaporate) return

    val density = LocalDensity.current
    val sizePx = with(density) { sizeDp.toPx() }
    val baseDropPx = with(density) { baseDropDp.toPx() }

    // ===== 点滅（A/B交互）=====
    var showA by remember { mutableStateOf(true) }
    LaunchedEffect(active, intervalMs) {
        if (!active) return@LaunchedEffect
        while (active) {
            delay(intervalMs)
            showA = !showA
        }
    }

    val aAlpha by animateFloatAsState(
        targetValue = if (showA) 1f else 0f,
        animationSpec = tween(crossFadeMs, easing = LinearEasing),
        label = "sparkleAAlpha"
    )
    val bAlpha by animateFloatAsState(
        targetValue = if (showA) 0f else 1f,
        animationSpec = tween(crossFadeMs, easing = LinearEasing),
        label = "sparkleBAlpha"
    )

    // ===== その場で“ふっ”と消える（α）＋少し縮む（scale）=====
    val groupAlpha = remember { Animatable(1f) }
    val groupScale = remember { Animatable(1f) }

    // activeになったら復帰
    LaunchedEffect(active) {
        if (active) {
            groupAlpha.snapTo(1f)
            groupScale.snapTo(1f)
        }
    }

    // evaporateでフェード＆縮小
    LaunchedEffect(evaporate, evapMs, shrinkTo) {
        if (!evaporate) return@LaunchedEffect

        // 念のため初期化
        groupAlpha.snapTo(1f)
        groupScale.snapTo(1f)

        val fadeJob = launch {
            groupAlpha.animateTo(
                0f,
                tween(evapMs, easing = FastOutSlowInEasing)
            )
        }
        val shrinkJob = launch {
            groupScale.animateTo(
                shrinkTo,
                tween(evapMs, easing = FastOutSlowInEasing)
            )
        }

        fadeJob.join()
        shrinkJob.join()
    }

    // ===== 位置（中心→左上）=====
    val left = (centerPx.x - sizePx / 2f).roundToInt()
    val baseTop = centerPx.y - sizePx / 2f + baseDropPx
    val top = baseTop.roundToInt()

    Box(modifier = modifier.fillMaxSize()) {
        // A
        Image(
            painter = painterResource(resA),
            contentDescription = null,
            modifier = Modifier
                .offset { IntOffset(left, top) }
                .size(sizeDp)
                .graphicsLayer {
                    alpha = aAlpha * groupAlpha.value
                    scaleX = groupScale.value
                    scaleY = groupScale.value
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                }
        )

        // B
        Image(
            painter = painterResource(resB),
            contentDescription = null,
            modifier = Modifier
                .offset { IntOffset(left, top) }
                .size(sizeDp)
                .graphicsLayer {
                    alpha = bAlpha * groupAlpha.value
                    scaleX = groupScale.value
                    scaleY = groupScale.value
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                }
        )
    }
}

/* =========================================================
   VoiceDiaryHomeScreen（図A〜D配置寄せ / logic-state分離前提）
   - home_state.kt / home_actions.kt / home_logic.kt を前提
   - 上にヘッダー固定（A_IDLEのみハンバーガー表示）
   - 上に通知カード+日記を読む（A_IDLEのみ）
   - 下に「水をあげる」+録音ボタン
   - B(1)(2)(3)の左ゲージ + 下に Watering... を表示
   - フェイズごとのヘッダー文言切替
   ========================================================= */
private val PICKED_ORB_BASE_SIZE = 110.dp

@Composable
fun VoiceDiaryHomeScreen(
    hasMicPermission: Boolean,
    hour: Int,
    minute: Int,
    enabled: Boolean,
    isRecording: Boolean, // 互換用（未使用でもOK）
    onRequestMicPermission: () -> Unit,
    onToggleEnabled: (Boolean) -> Unit,
    onPickTime: () -> Unit,
    onStartRecord: () -> Unit,
    onStopRecord: () -> Unit,
    onOpenArchive: () -> Unit,
    onRunGemini: () -> Unit,
    onCommitTranscription: (String) -> String,
    onSetMood: (String, Int?) -> Unit,
    transcriptionText: String,
    geminiLoading: Boolean,
    onDisposeStopIfNeeded: () -> Unit,
    amplitudeLevel: Float = 0f,
    archiveTotalCount: Int = 0,
    archiveThisMonthCount: Int = 0,
    archiveLastMonthCount: Int = 0
) {
    val baseBg = Color(0xFFF8F4FB)
    val accent = Color(0xFF4FC3F7)

    val logic = remember { VoiceDiaryHomeLogic() }
    val s = logic.state.value
    val scope = rememberCoroutineScope()

    // ========= UIアニメ用 =========
    val recordLevel = remember { Animatable(0f) } // 0..1（録音で上昇）
    val waterLevel = remember { Animatable(1f) }  // 1..0（水やりで減少）

    val panelScale = remember { Animatable(0.7f) }
    val panelAlpha = remember { Animatable(0f) }

    val expandRadius = remember { Animatable(0f) }
    val chaseRadius = remember { Animatable(0f) }
    val unselectedAlpha = remember { Animatable(1f) }

    val orbScale = remember { Animatable(1f) }
    val orbAlpha = remember { Animatable(1f) }

    val starsAlpha = remember { Animatable(0f) }
    val successScale = remember { Animatable(0.8f) }
    val successAlpha = remember { Animatable(0f) }

    //音声ゲージ＆ジョウロ内水量
    var gaugeProgress by remember { mutableStateOf(0f) }

    // ========= ジョウロ演出 =========
    val canFill = remember { Animatable(0f) }      // 0..1 水位
    val canTilt = remember { Animatable(0f) }      // degree（負で左に傾く）
    val pour = remember { Animatable(0f) }         // 0..1 注ぎ演出（線の出現/強さ）

    // ✅ 二重起動防止
    var afterPickRunning by remember { mutableStateOf(false) }

    // ✅ Orb（直線で吸い込み）
    val orbMotion = rememberFlyOrbState()
    val orbSpec = remember {
        FlySpec(
            durationMs = 1600,                  // 速度：遅くしたければ増やす
            easing = FastOutSlowInEasing,
            endPullPx = 14f
        )
    }

    // 選択された色を “パネルとは別レイヤー” で保持
    var pickedIndex by remember { mutableStateOf<Int?>(null) }

// 選択色丸の移動＆縮小＆消滅
    val flyPos = remember { Animatable(Offset.Zero, Offset.VectorConverter) }
    val flyScale = remember { Animatable(1f) }
    val flyAlpha = remember { Animatable(1f) }

    var orbPinnedPos by remember { mutableStateOf(Offset.Unspecified) }

// オーブ（周回）用
    val orbRotation = remember { Animatable(0f) }

// 花瓶中心（root座標）を取るため（すでにあるならそれを使う）
    var vaseCenter by remember { mutableStateOf(Offset.Zero) }

    val charge = remember { Animatable(0f) } // 0..1
    var orbStart by remember { mutableStateOf(Offset.Unspecified) }
    var orbEnd by remember { mutableStateOf(Offset.Unspecified) }

    fun maxRadius(): Float = hypot(s.rootW, s.rootH).coerceAtLeast(1f)

    // orbCenters（色丸中心）
    val orbCenters = remember { mutableStateListOf<Offset>() }
    LaunchedEffect(logic.moodColors.size) {
        orbCenters.clear()
        repeat(logic.moodColors.size) { orbCenters.add(Offset.Unspecified) }
    }

    var pickedPanelScale by remember { mutableStateOf(1f) }

    var sparkleEvaporate by remember { mutableStateOf(false) }

    var pickedOrbPos by remember { mutableStateOf<Offset?>(null) }
    var pickedOrbColor by remember { mutableStateOf<Color?>(null) }
    var showPickedOrb by remember { mutableStateOf(false) }
    // ✅ onPick の“溜め演出”を管理するJob
    var pickFxJob by remember { mutableStateOf<Job?>(null) }

    val orbDrawPos: Offset = when {
        orbMotion.isAnimating() -> orbMotion.currentOffset(orbSpec)
        (pickedOrbPos?.isValidOffset() == true) -> pickedOrbPos!!
        else -> Offset.Unspecified
    }

    // ========= reset =========
    suspend fun resetToIdleSuspend() {
        onStopRecord()

        recordLevel.snapTo(0f)
        waterLevel.snapTo(1f)
        panelScale.snapTo(0.7f)
        panelAlpha.snapTo(0f)
        expandRadius.snapTo(0f)
        chaseRadius.snapTo(0f)
        unselectedAlpha.snapTo(1f)
        orbScale.snapTo(1f)
        orbAlpha.snapTo(1f)
        starsAlpha.snapTo(0f)
        successScale.snapTo(0.8f)
        successAlpha.snapTo(0f)

        // サイズ/座標は引き継ぐ
        logic.state.value = UiState(
            phase = Phase.A_IDLE,
            rootW = s.rootW,
            rootH = s.rootH,
            vaseCenterPx = s.vaseCenterPx,
            flowerState = s.flowerState,
            archiveTotalCount = archiveTotalCount,
            archiveThisMonthCount = archiveThisMonthCount,
            archiveLastMonthCount = archiveLastMonthCount
        )
        pickFxJob?.cancel()
        pickFxJob = null
    }

    fun resetToIdle() {
        scope.launch { resetToIdleSuspend() }
    }

    // ========= phase駆動：外部コール =========
    LaunchedEffect(s.phase) {
        when (s.phase) {
            Phase.B_RECORDING_FILL -> onStartRecord()
            Phase.B_WATERING_DRAIN -> {
                onStopRecord()
                onRunGemini()
            }

            else -> Unit
        }
    }

    // ========= 録音：30秒カウント =========
    LaunchedEffect(s.phase) {
        if (s.phase == Phase.B_RECORDING_FILL) {

            gaugeProgress = 0f
            recordLevel.snapTo(0f)
            canFill.snapTo(0f)

            // ジョウロ：空にしてから満たす
            canTilt.snapTo(0f)
            pour.snapTo(0f)
            canFill.snapTo(0f)
            canFill.animateTo(1f, tween(900, easing = FastOutSlowInEasing))

            // ===== 既存の録音30秒処理（あなたのコードそのまま）=====
            logic.state.value = logic.state.value.copy(remainRecord = 30)
            recordLevel.snapTo(0f)

            while (logic.state.value.remainRecord > 0 && logic.state.value.phase == Phase.B_RECORDING_FILL) {
                val rr = logic.state.value.remainRecord
                delay(1000)
                logic.state.value = logic.state.value.copy(remainRecord = rr - 1)
            }

            if (logic.state.value.phase == Phase.B_RECORDING_FILL) {
                logic.state.value = logic.state.value.copy(phase = Phase.B_WATERING_DRAIN)
            }
        }
    }

    // ========= 水やり =========
    LaunchedEffect(s.phase) {
        if (s.phase == Phase.B_WATERING_DRAIN) {
            logic.state.value = logic.state.value.copy(
                bottomText = "Watering your heart...",
                bottomTextVisible = true
            )

            // ジョウロ：満タン開始 → 傾ける → 注ぐ → 元に戻す
            // （B_RECORDING_FILL で満タンにしてる想定なので snapTo(1f) は保険）
            canFill.snapTo(1f)
            canTilt.snapTo(0f)
            pour.snapTo(0f)

            val tiltJob = launch {
                canTilt.animateTo(-32f, tween(420, easing = FastOutSlowInEasing))
            }
            val pourInJob = launch {
                // 少し遅れて水が出る
                delay(140)
                pour.animateTo(1f, tween(220, easing = FastOutSlowInEasing))
            }
            tiltJob.join()
            pourInJob.join()

            // 注いでる間に水位が下がる
            val drainMs = 1400
            val drainJob = launch {
                canFill.animateTo(0f, tween(drainMs, easing = LinearEasing))
            }

            // 左ゲージの既存 waterLevel も併走
            waterLevel.snapTo(1f)
            val gaugeJob = launch {
                waterLevel.animateTo(0f, tween(1800, easing = LinearEasing))
            }

            drainJob.join()
            gaugeJob.join()

            // 注ぎ終わり
            val pourOutJob = launch {
                pour.animateTo(0f, tween(180, easing = FastOutSlowInEasing))
            }
            val backJob = launch {
                canTilt.animateTo(0f, tween(360, easing = FastOutSlowInEasing))
            }
            pourOutJob.join()
            backJob.join()

            if (logic.state.value.phase == Phase.B_WATERING_DRAIN) {
                logic.state.value = logic.state.value.copy(phase = Phase.B_SPARKLE)
            }
        }
    }

    LaunchedEffect(s.phase, amplitudeLevel) {
        if (s.phase == Phase.B_RECORDING_FILL) {
            val level = amplitudeLevel.coerceIn(0f, 1f)

            gaugeProgress = (gaugeProgress + level * 0.02f)
                .coerceIn(0f, 1f)

            recordLevel.snapTo(gaugeProgress)
            canFill.snapTo(gaugeProgress)
        }
    }

    // ========= キラキラ短く =========
    LaunchedEffect(s.phase) {
        if (s.phase == Phase.B_SPARKLE) {
            sparkleEvaporate = false
            delay(SPARKLE_BLINK_MS)

            sparkleEvaporate = true
            delay(SPARKLE_EVAP_MS.toLong())

            if (logic.state.value.phase == Phase.B_SPARKLE) {
                logic.state.value = logic.state.value.copy(phase = Phase.C_PANEL_REVEAL)
            }
        }
    }

    // ========= 色パネル展開 =========
    LaunchedEffect(s.phase) {
        if (s.phase == Phase.C_PANEL_REVEAL) {
            logic.state.value = logic.state.value.copy(
                bottomTextVisible = false  // ✅ 常に非表示
            )

            delay(90)

            logic.state.value = logic.state.value.copy(panelVisible = true)

            panelScale.snapTo(0.7f)
            panelAlpha.snapTo(0f)
            panelAlpha.animateTo(1f, tween(180))
            panelScale.animateTo(1f, tween(260, easing = FastOutSlowInEasing))
        }
    }

    // ========= API完了→保存 =========
    LaunchedEffect(geminiLoading, transcriptionText, s.phase, s.didCommit) {
        if (s.phase != Phase.A_IDLE && !geminiLoading && !s.didCommit) {
            val text = transcriptionText.ifBlank { "（文字起こし結果が空です）" }
            val id = onCommitTranscription(text)
            logic.state.value = logic.state.value.copy(savedEntryId = id, didCommit = true)
        }
    }

    // ========= 色選択後シーケンス =========
    fun launchAfterPickSequence() {
        if (afterPickRunning) return
        afterPickRunning = true

        scope.launch {
            try {
                val mr = maxRadius()

                // 1) cover開始
                logic.state.value = logic.state.value.copy(phase = Phase.C_COLOR_EXPAND)
                expandRadius.snapTo(0f)
                chaseRadius.snapTo(0f)

                val coverJob = launch {
                    expandRadius.animateTo(mr, tween(1400, easing = FastOutSlowInEasing))
                }

                val clearJob = launch {
                    delay(140)
                    logic.state.value = logic.state.value.copy(phase = Phase.C_PANEL_DISMISS)
                    chaseRadius.animateTo(mr, tween(3000, easing = FastOutSlowInEasing))
                }

                // ✅ cover/clear が終わるまで待つ
                coverJob.join()
                clearJob.join()

                // ✅ 溜め演出がまだ走ってたら止める（後からorbScale/chargeを書き換えて戻りが出るのを防ぐ）
                pickFxJob?.cancel()
                pickFxJob = null

                // 2) ✅ 選んだ色丸を花瓶中心へ吸い込み
                val start = pickedOrbPos ?: Offset.Unspecified
                val end = logic.state.value.vaseCenterPx
                    .takeIf { it.isValidOffset() }
                    ?: Offset(logic.state.value.rootW * 0.5f, logic.state.value.rootH * 0.55f)

                if (start.isValidOffset() && end.isValidOffset()) {
                    showPickedOrb = true
                    orbAlpha.snapTo(1f)
                    orbScale.snapTo(1f)

                    // オーブ感
                    charge.snapTo(0f)
                    charge.animateTo(1f, tween(260, easing = FastOutSlowInEasing))

                    val flyMs = 650

                    // ✅ 同時に走らせて、両方終わるまで待つ
                    val moveJob = launch {
                        orbMotion.animate(start, end, orbSpec)
                    }

// ✅ 位置追従ジョブ（これがないと、posが途中で止まったり切り替わる）
                    val followJob = launch {
                        while (orbMotion.isAnimating()) {
                            orbPinnedPos = orbMotion.currentOffset(orbSpec)
                            withFrameNanos { } // 1フレーム待つ
                        }
                        // アニメ終了後は終点に固定
                        orbPinnedPos = end
                    }

                    val shrinkJob = launch {
                        orbScale.animateTo(0.28f, tween(650, easing = FastOutSlowInEasing))
                    }

                    moveJob.join()
                    followJob.join()
                    shrinkJob.join()

                    // ✅ 到着後：ここでフェードしてる間も orbPinnedPos は end のまま（絶対戻らない）
                    charge.animateTo(0f, tween(160))
                    orbAlpha.animateTo(0f, tween(220, easing = FastOutSlowInEasing))

                    // ✅ 完全に消えてから破棄
                    showPickedOrb = false
                    pickedOrbPos = null
                    pickedOrbColor = null
                    orbPinnedPos = Offset.Unspecified
                    orbMotion.reset() // resetあるなら最後でOK
                }

                // 3) 以降は既存ロジック
                logic.runAfterPickSequence(
                    orbCenters = orbCenters,
                    onSetMood = onSetMood
                )

                // 星/success（あなたの既存のままでOK）
                if (logic.state.value.phase == Phase.D_STARS) {
                    starsAlpha.snapTo(0f)
                    starsAlpha.animateTo(1f, tween(180))
                    delay(500)
                    starsAlpha.animateTo(0f, tween(220))
                }
                if (logic.state.value.phase == Phase.D_SUCCESS) {
                    successAlpha.snapTo(0f)
                    successScale.snapTo(0.85f)
                    successAlpha.animateTo(1f, tween(120))
                    successScale.animateTo(1f, spring(stiffness = Spring.StiffnessMediumLow))
                    delay(500)
                }
            } finally {
                afterPickRunning = false
            }

        }
    }

    LaunchedEffect(s.phase) {
        if (s.phase == Phase.D_SUCCESS) {
            successAlpha.snapTo(0f)
            successScale.snapTo(0.85f)
            successAlpha.animateTo(1f, tween(120))
            successScale.animateTo(1f, spring(stiffness = Spring.StiffnessMediumLow))
        }
    }

    DisposableEffect(Unit) {
        onDispose { onDisposeStopIfNeeded() }
    }

    // ===================== UI =====================
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(baseBg)
            .onSizeChanged {
                logic.dispatch(
                    HomeAction.RootSizeChanged(
                        it.width.toFloat(),
                        it.height.toFloat()
                    )
                )

            }
    ) {

        // 背景（あるなら）
        Image(
            painter = painterResource(R.drawable.home_bg_shelf),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // ===== ジョウロ（水が満ちる→傾けて注ぐ）=====
        val showCan = (s.phase == Phase.B_RECORDING_FILL || s.phase == Phase.B_WATERING_DRAIN)
        if (showCan) {
            WateringCanAnimLayer(
                canBackRes = R.drawable.jouro_back_manual,
                canFrontRes = R.drawable.jouro_front_manual,
                fill = canFill.value,
                tiltDeg = canTilt.value,
                pour = pour.value,
                rootW = s.rootW,
                rootH = s.rootH,
                target = (logic.state.value.vaseCenterPx.takeIf { it.isValidOffset() }
                    ?: Offset(s.rootW * 0.5f, s.rootH * 0.55f)) + Offset(0f, -110f),
                modifier = Modifier.zIndex(22f)
            )
        }

        // 花＋鉢（中心）
        Box(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter)
                .offset(y = (-250).dp) // ← 棚の高さ
                .onGloballyPositioned { coords ->
                    val r = coords.boundsInRoot()
                    vaseCenter = Offset(r.left + r.width / 2f, r.top + r.height / 2f)
                }
        ) {

            Image(
                painter = painterResource(R.drawable.uekihaci1_safe),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(120.dp)
                    .offset(y = (-50).dp)
                    .onGloballyPositioned { coords ->
                        val r = coords.boundsInRoot() // Rect(left, top, right, bottom)
                        val center = Offset(r.left + r.width / 2f, r.top + r.height / 2f)

                        // 無限再compose防止：少し以上動いた時だけ更新
                        val prev = logic.state.value.vaseCenterPx
                        val dx = center.x - prev.x
                        val dy = center.y - prev.y
                        if (center.isValidOffset() && (dx * dx + dy * dy) > 0.25f) {
                            logic.state.value = logic.state.value.copy(vaseCenterPx = center)
                        }
                    }
            )

            Image(
                painter = painterResource(R.drawable.flower_anemone),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(200.dp)
                    .offset(y = (-155).dp)
            )
            val sparkleCenter =
                logic.state.value.vaseCenterPx.takeIf { it.isValidOffset() }
                    ?: Offset(s.rootW * 0.5f, s.rootH * 0.55f)

            SparkleBlinkWithEvaporate(
                active = (s.phase == Phase.B_SPARKLE),
                evaporate = sparkleEvaporate,
                centerPx = sparkleCenter,
                resA = R.drawable.kirakira11,
                resB = R.drawable.kirakira22,
                modifier = Modifier.zIndex(120f),
                baseDropDp = 180.dp,
                intervalMs = 260L,
                evapMs = 520,
                shrinkTo = 0.86f
            )
        }


        val selColor =
            remember(s.selectedArgb) { Color(s.selectedArgb ?: Color.White.toArgb()) }

// ✅ 色で覆う→透明円で戻す（この2フェイズの間だけ表示）
        val showCoverReveal =
            (s.phase == Phase.C_COLOR_EXPAND || s.phase == Phase.C_PANEL_DISMISS)

        if (showCoverReveal) {
            CoverRevealLayer(
                origin = s.expandOrigin,
                coverRadius = expandRadius.value,   // 色で覆う半径
                clearRadius = chaseRadius.value,    // 透明でくり抜く半径
                color = selColor,
                w = s.rootW,
                h = s.rootH,
                modifier = Modifier.zIndex(6f)      // だいたいこのへんでOK
            )
        }

        // 2枚目寄せ：上のオーバーレイ（A_IDLEだけ）
        if (s.phase == Phase.A_IDLE) {
            HomeOverlayTopRow(
                hour = hour,
                minute = minute,
                enabled = enabled,
                onToggleEnabled = onToggleEnabled,
                onPickTime = onPickTime,
                onOpenArchive = onOpenArchive,
                // ★ヘッダー(72dp)分だけ下げる：72 + 10 = 82
                modifier = Modifier.zIndex(20f)
            )
        }

        // 左ゲージ（録音/水やり）
        val showGauge = (s.phase == Phase.B_RECORDING_FILL || s.phase == Phase.B_WATERING_DRAIN)
        if (showGauge) {
            val level =
                if (s.phase == Phase.B_RECORDING_FILL) recordLevel.value else waterLevel.value
            LeftGauge(
                level = level,
                modifier = Modifier.zIndex(25f)
            )
        }

        // 下：録音ボタン + 「水をあげる」
        val showCenterButton = (s.phase == Phase.A_IDLE || s.phase == Phase.B_RECORDING_FILL)
        if (showCenterButton) {
            BottomCenterAction(
                phase = s.phase,
                accent = accent,
                onClickCenter = { logic.dispatch(HomeAction.ClickCenter) },
                onCancel = { resetToIdle() },
                modifier = Modifier.zIndex(30f)
            )
        }


        // ✅ bottomText（Watering... / Select...）を描画
        // ✅ bottomText は「画像が出るフェイズ」では出さない（重なり防止）
        val showBottomText =
            s.bottomTextVisible && (s.phase !in listOf(
                Phase.B_WATERING_DRAIN,
                Phase.B_SPARKLE,
                Phase.C_PANEL_REVEAL,
                Phase.D_SUCCESS // successも画像を使うなら文字は出さない
            ))

        if (showBottomText) {
            BottomScriptTextSmart(
                phase = s.phase,
                text = s.bottomText,
                modifier = Modifier.zIndex(35f)
            )
        }

        // 色選択パネル
        val centersReady = orbCenters.isNotEmpty() && orbCenters.all { it.isValidOffset() }
        val rootReady = s.rootW > 0f && s.rootH > 0f

        val enabledPickSafe =
            (s.phase == Phase.C_PANEL_REVEAL && s.panelVisible && s.selectedIndex == null && centersReady && rootReady)

// ✅ 選んだ色丸だけ残す（C演出中）は panelVisible と無関係に描画する
        val showPickedOrbLayer = showPickedOrb || orbMotion.isAnimating()

        if (showPickedOrbLayer) {
            OrbLayer(
                pos = orbPinnedPos,                 // ✅ ここだけを見る
                color = pickedOrbColor ?: Color.White,
                sizeDp = PICKED_ORB_BASE_SIZE,
                scale = orbScale.value,
                alpha = orbAlpha.value,
                charge = charge.value,
                modifier = Modifier.zIndex(58f)
            )
        }

        if (s.panelVisible) {
            // モーダル背景（背面を暗くする）
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(50f)
                    .background(Color.Black.copy(alpha = 0.45f))
                    // 背景タップで閉じたいなら onSkip 相当を呼ぶ（閉じたくないなら clickable 自体削除）
                    .clickable(
                        indication = null,
                        interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
                    ) { /* 何もしない */ },
                contentAlignment = Alignment.Center
            ) {
                // 中央の小窓
                ColorPanel(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(220.dp),
                    scale = panelScale.value,
                    alpha = panelAlpha.value,
                    unselectedAlpha = unselectedAlpha.value,
                    colors = logic.moodColors,
                    orbCenters = orbCenters,
                    enabledPick = enabledPickSafe,
                    onPick = { idx ->
                        val fallback = logic.state.value.vaseCenterPx.takeIf { it.isValidOffset() }
                            ?: Offset(
                                (s.rootW.takeIf { it > 0f } ?: 1080f) * 0.5f,
                                (s.rootH.takeIf { it > 0f } ?: 1920f) * 0.5f
                            )

                        val c = orbCenters.getOrNull(idx)?.takeIf { it.isValidOffset() }
                            ?: fallback

                        val picked = logic.moodColors[idx]

                        // expand起点
                        logic.state.value = logic.state.value.copy(expandOrigin = c)
                        logic.dispatch(HomeAction.PickMood(idx))

                        // ✅ 選んだ丸だけ残す準備（パネル外で描画する）
                        pickedOrbPos = c
                        pickedOrbColor = picked
                        orbPinnedPos = c          // ✅ 追加：描画位置はここで固定
                        showPickedOrb = true

                        // ✅ 透明化されてたら復帰（これをやらないと“消えてる”が起きる）
                        pickFxJob = scope.launch {
                            orbAlpha.snapTo(1f)
                            orbScale.snapTo(1f)

                            // オーブ感を最初から維持したいなら
                            if (charge.value < 0.35f) charge.snapTo(0.35f)

                            // まず“固定表示”として出す（既存の showPickedOrb を利用）
                            showPickedOrb = true

                            // チャージ（オーブ化）
                            charge.snapTo(0f)
                            orbScale.snapTo(1f)
                            orbAlpha.snapTo(1f)

                            // ちょい縮んで→膨らむ（溜め）
                            val squash = launch {
                                orbScale.animateTo(
                                    0.96f,
                                    tween(90, easing = FastOutSlowInEasing)
                                )
                            }
                            val chargeUp = launch {
                                charge.animateTo(
                                    1f,
                                    tween(240, easing = FastOutSlowInEasing)
                                )
                            }
                            squash.join(); chargeUp.join()
                            orbScale.animateTo(1.08f, tween(120, easing = FastOutSlowInEasing))
                            orbScale.animateTo(1.00f, tween(120, easing = FastOutSlowInEasing))

                            // 螺旋移動（チャージは少し残すと気持ちいい）
                            charge.animateTo(0.35f, tween(140))

                            // ✅ 最低限のオーブ感を残しておく
                            charge.snapTo(0.35f)
                            println("onPick called idx=$idx c=$c")

                        }

                        // ✅ 窓/他の丸を消す（フェード → 非表示）
                        scope.launch {
                            panelAlpha.animateTo(0f, tween(90))
                            logic.state.value = logic.state.value.copy(panelVisible = false)
                        }

                        // ✅ 演出開始
                        launchAfterPickSequence()
                    },
                    onSkip = {
                        val entryId = s.savedEntryId
                        if (entryId != null) onSetMood(entryId, null)
                        resetToIdle()
                    }
                )

            }
        }

        // 花瓶へ向かう丸
        /*if (s.orbVisible) {
            OrbLayer(
                pos = s.orbPos,
                color = s.orbColor,
                scale = orbScale.value,
                alpha = orbAlpha.value,
                modifier = Modifier.zIndex(60f)
            )
        }*/

        // 星
        val starCenter =
            logic.state.value.vaseCenterPx.takeIf { it.isValidOffset() }
                ?: Offset(s.rootW * 0.5f, s.rootH * 0.55f)

        StarsBurstScatterLayer(
            center = starCenter,
            show = (s.phase == Phase.D_STARS),
            fadeOutTrigger = (s.phase == Phase.D_SUCCESS),
            modifier = Modifier.zIndex(70f),
            resStar = R.drawable.star1,   // 1枚目の星PNG
            bigCount = 3,
            midCount = 4,
            smallCount = 4,
            radiusMinDp = 80.dp,
            radiusMaxDp = 160.dp
        )


        // ★ フェイズ文字（B,C,Successすべて）
        PhaseTextImageOverlay(
            phase = s.phase,
            modifier = Modifier.zIndex(80f),
            successScale = successScale.value,
            successAlpha = successAlpha.value
        )


        // 権限（A_IDLEだけでOK）
        if (s.phase == Phase.A_IDLE && !hasMicPermission) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(90f)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("マイク権限が必要です", color = Color.Red, fontFamily = KosugiMaru)
                Spacer(Modifier.height(6.dp))
                Button(onClick = onRequestMicPermission) {
                    Text(
                        "マイク権限を許可",
                        fontFamily = KosugiMaru
                    )
                }
            }
        }

        // ✅✅✅ ここが重要：ヘッダーを最前面で固定表示
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .zIndex(9999f)
        ) {
            HeaderArea(
                phase = s.phase,
                onHamburger = {
                    // TODO: ハンバーガー押下時の処理
                    // 例: ドロワーを開く / メニュー表示
                }
            )
        }
    }
}





/* -----------------------------
   花＆植木鉢
------------------------------ */
@Composable
private fun FlowerAndVaseLayerAnchored(
    flowerId: String,
    vaseId: String,
    depth: Float,
    rootW: Float,
    rootH: Float,
    onVaseCenterChanged: (Offset) -> Unit
) {
    val flowerRes = AssetCatalog.flowerRes(flowerId)
    val vaseRes = AssetCatalog.vaseRes(vaseId)

    // 棚の上面（ここは要調整：背景に合わせて比率で固定）
    val shelfTop = off(rootW * 0.5f, rootH * 0.78f)

    val density = LocalDensity.current
    val vaseSizePx = with(density) { 220.dp.toPx() }
    val flowerSizePx = with(density) { 260.dp.toPx() }

    // 花瓶：底アンカーを shelfTop に合わせて配置
    AnchoredImage(
        resId = vaseRes,
        sizeDp = 220f,
        placeAnchorOnScreen = shelfTop,
        imageAnchor = VaseBottomAnchor
    )

    // 花瓶の「口」位置（底→口の差分をpxで出す）
    val mouthFromBottom = off(
        (VaseMouthAnchor.x - VaseBottomAnchor.x) * vaseSizePx,
        (VaseMouthAnchor.y - VaseBottomAnchor.y) * vaseSizePx
    )
    val vaseMouthOnScreen = add(shelfTop, mouthFromBottom)

    // 花：stemアンカーを花瓶の口に合わせて配置
    AnchoredImage(
        resId = flowerRes,
        sizeDp = 260f,
        placeAnchorOnScreen = vaseMouthOnScreen,
        imageAnchor = FlowerStemAnchor,
        colorFilter = depthColorFilterOrNull(depth)
    )

    // vaseCenter（必要なら計算で渡す：花瓶画像の中心＝Anchor(0.5,0.5)扱い）
    val vaseCenter = off(
        shelfTop.x + (0.5f - VaseBottomAnchor.x) * vaseSizePx,
        shelfTop.y + (0.5f - VaseBottomAnchor.y) * vaseSizePx
    )
    onVaseCenterChanged(vaseCenter)
}
private fun depthColorFilterOrNull(depth: Float): ColorFilter? {
    if (depth <= 0f) return null
    val d = depth.coerceIn(0f, 1f)
    val m = ColorMatrix().apply { setToSaturation(1f + 0.35f * d) }
    return ColorFilter.colorMatrix(m)
}

@Composable
private fun AnchoredImage(
    resId: Int,
    sizeDp: Float,
    placeAnchorOnScreen: Offset,
    imageAnchor: Anchor,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    val density = LocalDensity.current
    val sizePx = with(density) { sizeDp.dp.toPx() }

    Image(
        painter = painterResource(resId),
        contentDescription = null,
        modifier = modifier
            .graphicsLayer {
                translationX = placeAnchorOnScreen.x - (sizePx * imageAnchor.x)
                translationY = placeAnchorOnScreen.y - (sizePx * imageAnchor.y)
            }
            .size(sizeDp.dp),
        colorFilter = colorFilter,
        contentScale = ContentScale.Fit
    )
}

/* -----------------------------
   2枚目寄せ：上の行
------------------------------ */
@Composable
private fun HomeOverlayTopRow(
    hour: Int,
    minute: Int,
    enabled: Boolean,
    onToggleEnabled: (Boolean) -> Unit,
    onPickTime: () -> Unit,
    onOpenArchive: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            // ★ヘッダー分下げる
            .padding(start = 12.dp, end = 12.dp, top = 82.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        CompactTimeCard(
            hour = hour,
            minute = minute,
            enabled = enabled,
            onToggleEnabled = onToggleEnabled,
            onPickTime = onPickTime
        )

        ArchiveTopButton(onClick = onOpenArchive)
    }
}

@Composable
private fun CompactTimeCard(
    hour: Int,
    minute: Int,
    enabled: Boolean,
    onToggleEnabled: (Boolean) -> Unit,
    onPickTime: () -> Unit,
    modifier: Modifier = Modifier
) {
    fun mm(n: Int) = n.toString().padStart(2, '0')

    Surface(
        modifier = modifier.width(190.dp),
        shape = RoundedCornerShape(14.dp),
        color = Color.White.copy(alpha = 0.80f),
        shadowElevation = 6.dp
    ) {
        Column(Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text("通知時刻", fontFamily = KosugiMaru, fontSize = 14.sp, color = Color(0xFF222222))
            }

            Spacer(Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${mm(hour)}:${mm(minute)}",
                    fontFamily = KosugiMaru,
                    fontSize = 26.sp,
                    color = Color(0xFF111111),
                    modifier = Modifier.weight(1f)
                )

                Switch(
                    checked = enabled,
                    onCheckedChange = onToggleEnabled,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFF7A2DFF),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color(0xFFBDBDBD)
                    )
                )
            }

            Spacer(Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .height(34.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Brush.horizontalGradient(listOf(Color(0xFF7A2DFF), Color(0xFF4FC3F7))))
                    .clickable { onPickTime() },
                contentAlignment = Alignment.Center
            ) {
                Text("設定", fontFamily = KosugiMaru, fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Composable
private fun ArchiveTopButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .height(42.dp)
            .width(140.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(999.dp),
        color = Color.White.copy(alpha = 0.65f),
        shadowElevation = 6.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text("日記を読む", fontFamily = KosugiMaru, fontSize = 18.sp, color = Color(0xFF333333))
        }
    }
}

/* -----------------------------
   下：水をあげる + 録音ボタン（図A）
------------------------------ */
@Composable
private fun BottomCenterAction(
    phase: Phase,
    accent: Color,
    onClickCenter: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 30.dp)
        ) {

            // ✅ ここが「水をあげる」と同じ場所（padding bottom=10dp）の枠
            Box(modifier = Modifier.padding(bottom = 10.dp)) {

                androidx.compose.animation.AnimatedVisibility(
                    visible = (phase == Phase.A_IDLE),
                    enter = fadeIn(tween(150)),
                    exit = fadeOut(tween(120))
                ) {
                    Text(
                        "水をあげる",
                        fontFamily = KosugiMaru,
                        fontSize = 28.sp,
                        color = Color.White
                    )
                }

                androidx.compose.animation.AnimatedVisibility(
                    visible = (phase == Phase.B_RECORDING_FILL),
                    enter = fadeIn(tween(150)),
                    exit = fadeOut(tween(120))
                ) {
                    val shape = RoundedCornerShape(999.dp)
                    OutlinedButton(
                        onClick = onCancel,
                        shape = shape,
                        border = BorderStroke(2.dp, Color(0xFF4FC3F7)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF4FC3F7)
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .height(48.dp)
                    ) {
                        Text("キャンセル", fontFamily = KosugiMaru, fontSize = 18.sp)
                    }
                }
            }

            MicOrRecordingButton(
                isActive = (phase != Phase.A_IDLE),
                accent = accent,
                enabled = (phase == Phase.A_IDLE || phase == Phase.B_RECORDING_FILL),
                content = when (phase) {
                    Phase.A_IDLE -> CenterButtonContent.MIC
                    Phase.B_RECORDING_FILL -> CenterButtonContent.BARS
                    else -> CenterButtonContent.CHECK
                },
                onClick = onClickCenter
            )
        }
    }
}

/* -----------------------------
   左ゲージ（図B）
------------------------------ */
@Composable
private fun LeftGauge(
    level: Float,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(999.dp)

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .width(14.dp)
                .height(240.dp)
                .clip(shape)
                .background(Color(0xFF000000).copy(alpha = 0.35f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(level.coerceIn(0f, 1f))
                    .align(Alignment.BottomCenter)
                    .clip(shape)
                    .background(Color(0xFF2ECC71))
            )
        }
    }
}

/* -----------------------------
   下の手書き風テキスト（図B(2)(3)）
------------------------------ */
@Composable
private fun BottomScriptText(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 18.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = text,
            fontFamily = KosugiMaru,
            fontSize = 26.sp,
            color = Color.Black.copy(alpha = 0.75f)
        )
    }
}

@Composable
private fun BottomScriptTextSmart(
    phase: Phase,
    text: String,
    modifier: Modifier = Modifier
) {
    // ✅ ここで “サイズ” と “位置” を調整できる
    val (fontSize, bottomPadding) = when (phase) {
        Phase.B_WATERING_DRAIN, Phase.B_SPARKLE -> 26.sp to 26.dp   // Watering...
        Phase.C_PANEL_REVEAL -> 24.sp to 34.dp                      // Select...
        else -> 26.sp to 18.dp
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = bottomPadding),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = text,
            fontFamily = KosugiMaru,
            fontSize = fontSize,
            color = Color.Black.copy(alpha = 0.75f)
        )
    }
}

@Composable
private fun PhaseTextImageOverlay(
    phase: Phase,
    modifier: Modifier = Modifier,
    successScale: Float = 1f,
    successAlpha: Float = 1f,
) {
    val (res, widthFrac, heightDp, useAnim) = when (phase) {
        Phase.B_WATERING_DRAIN, Phase.B_SPARKLE ->
            Quad(R.drawable.phase_b_select, 0.9f, null, false)

        Phase.C_PANEL_REVEAL ->
            Quad(R.drawable.phase_c_select, 0.9f, null, false)

        Phase.D_SUCCESS ->
            Quad(R.drawable.phase_d_select, null, 140.dp, true)

        else -> return
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 18.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(res),
            contentDescription = null,
            modifier = Modifier
                .then(
                    when {
                        heightDp != null -> Modifier.height(heightDp)
                        widthFrac != null -> Modifier.fillMaxWidth(widthFrac)
                        else -> Modifier
                    }
                )
                .then(
                    if (useAnim) {
                        Modifier.graphicsLayer {
                            scaleX = successScale
                            scaleY = successScale
                            alpha = successAlpha
                        }
                    } else Modifier
                ),
            contentScale = ContentScale.Fit
        )
    }
}

private data class Quad(
    val res: Int,
    val widthFrac: Float?,
    val heightDp: Dp?,
    val useAnim: Boolean
)

/* -----------------------------
   色パネル
------------------------------ */
@Composable
private fun ColorPanel(
    modifier: Modifier,
    scale: Float,
    alpha: Float,
    unselectedAlpha: Float,
    colors: List<Color>,
    orbCenters: MutableList<Offset>,
    enabledPick: Boolean,
    onPick: (Int) -> Unit,
    onSkip: () -> Unit
) {
    // ✅ パネルの“外側”でサイズを確定させる（callerのmodifierに負けない）
    val panelShape = RoundedCornerShape(24.dp)

    val panelModifier = Modifier
        .fillMaxWidth(0.95f)
        .height(480.dp)                 // ← サイズ確定（ここが最優先）
        .graphicsLayer { this.alpha = alpha } // ← 見た目だけ
        .clip(panelShape)               // ← 見た目だけ
        .background(Color.White.copy(alpha = 0.92f), panelShape)
        .padding(horizontal = 26.dp, vertical = 22.dp)
        .then(modifier)                 // ← 呼び出し側modifierは最後に適用（現状維持）

    Box(
        modifier = panelModifier,
        contentAlignment = Alignment.Center
    ) {
        // ✅ 歪み防止：等倍スケール（横だけ伸びる事故を防ぐ）
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.scale(scale)
                .navigationBarsPadding()      // ✅ 追加（端末のジェスチャーバー対策）
                .padding(bottom = 18.dp)      // ✅ 追加（保険）
        ) {
            Text(
                "今日の気分の色をタップして！",
                fontFamily = KosugiMaru,
                fontSize = 20.sp,
                color = Color(0xFF222222)
            )
            Spacer(Modifier.height(18.dp))

            val a = if (enabledPick) 1f else unselectedAlpha

            // ✅ 高さを増やした分、色面も大きく取る
            val boardSize = 440.dp
            val circleSize = 110.dp
            val inset = 14.dp

            Box(
                modifier = Modifier
                    .size(boardSize)
                    .padding(inset)
            ) {
                val spotAlignments = listOf(
                    Alignment.TopStart,
                    Alignment.TopEnd,
                    Alignment.Center,
                    Alignment.BottomStart,
                    Alignment.BottomEnd
                )
                val count = minOf(colors.size, spotAlignments.size)

                for (idx in 0 until count) {
                    val c = colors[idx]
                    Box(
                        modifier = Modifier
                            .size(PICKED_ORB_BASE_SIZE)
                            .clip(CircleShape)
                            .background(c.copy(alpha = a))
                            .align(spotAlignments[idx])
                            .onGloballyPositioned { coords ->
                                if (idx < orbCenters.size) {
                                    val r = coords.boundsInRoot()
                                    orbCenters[idx] = Offset(
                                        r.left + r.width / 2f,
                                        r.top + r.height / 2f
                                    )
                                }
                            }
                            .then(if (enabledPick) Modifier.clickable { onPick(idx) } else Modifier)
                    )
                }
            }

            Spacer(Modifier.height(18.dp))
            TextButton(onClick = onSkip) {
                Text(
                    "SKIP",
                    textDecoration = TextDecoration.Underline,
                    fontSize = 26.sp,
                    fontFamily = KosugiMaru
                )
            }
        }
    }
}

/* -----------------------------
   色塗りつぶし
------------------------------ */
@Composable
private fun ColorExpandLayer(
    origin: Offset,
    radius: Float,
    color: Color,
    w: Float,
    h: Float,
    modifier: Modifier = Modifier
) {
    if (w <= 0f || h <= 0f) return
    val center = if (origin.isValidOffset()) origin else Offset(w / 2f, h / 2f)

    Canvas(modifier.fillMaxSize()) {
        val r = radius
        if (r > 0.5f) {
            val path = Path().apply {
                addOval(Rect(center.x - r, center.y - r, center.x + r, center.y + r))
            }
            clipPath(path) { drawRect(color = color) }
        }
    }
}

@Composable
private fun CoverRevealLayer(
    origin: Offset,
    coverRadius: Float,
    clearRadius: Float,
    color: Color,
    w: Float,
    h: Float,
    modifier: Modifier = Modifier
) {
    if (w <= 0f || h <= 0f) return
    val center = if (origin.isValidOffset()) origin else Offset(w / 2f, h / 2f)

    Canvas(
        modifier = modifier
            .fillMaxSize()
            // ✅ Clear を効かせるため必須
            .graphicsLayer { compositingStrategy = CompositingStrategy.Offscreen }
    ) {
        if (coverRadius <= 0.5f) return@Canvas

        // 1) coverRadius の円の中だけ“色”を描く（全面塗りはしない）
        val coverPath = Path().apply {
            addOval(Rect(center.x - coverRadius, center.y - coverRadius, center.x + coverRadius, center.y + coverRadius))
        }
        clipPath(coverPath) {
            drawRect(color = color)
        }

        // 2) clearRadius の円を “透明で抜く” → 色リングになる
        if (clearRadius > 0.5f) {
            drawCircle(
                color = Color.Transparent,
                radius = clearRadius,
                center = center,
                blendMode = BlendMode.Clear
            )
        }
    }
}

/* -----------------------------
   花瓶へ向かう丸
------------------------------ */
@Composable
private fun OrbLayer(
    pos: Offset,
    color: Color,
    sizeDp: Dp = PICKED_ORB_BASE_SIZE,
    scale: Float,
    alpha: Float,
    charge: Float = 0f,
    modifier: Modifier = Modifier
) {
    if (!pos.isValidOffset()) return

    val density = LocalDensity.current
    val sizePx = with(density) { sizeDp.toPx() } // ✅ 半径補正に使う

    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                // ✅ pos(中心) → offset(左上) に変換
                .offset {
                    IntOffset(
                        (pos.x - sizePx / 2f).roundToInt(),
                        (pos.y - sizePx / 2f).roundToInt()
                    )
                }
                .size(sizeDp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    this.alpha = alpha
                }
        ) {
            Canvas(Modifier.fillMaxSize()) {
                val r = size.minDimension / 2f
                val c = Offset(size.width / 2f, size.height / 2f)

                // ---- 外側グロー（オーブ感）----
                val glowA = (0.0f + 0.85f * charge) * 0.3f
                if (glowA > 0.001f) {
                    drawCircle(color.copy(alpha = glowA), radius = r * 1.25f, center = c)
                    drawCircle(color.copy(alpha = glowA * 0.55f), radius = r * 1.55f, center = c)
                }

                // ---- 本体 ----
                drawCircle(color = color, radius = r, center = c)

                // ✅ 常時輪郭リング（背景が同色でも消えない）
                drawCircle(
                    color = Color.White.copy(alpha = 0.28f), // 好みで 0.18〜0.40
                    radius = r - r * 0.08f,
                    center = c,
                    style = Stroke(width = r * 0.10f)        // 好みで 0.06〜0.14
                )

                // ---- 光沢（上部ハイライト）----
                val hiA = 0.14f + 0.45f * charge
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.White.copy(alpha = hiA),
                            Color.White.copy(alpha = hiA * 0.35f),
                            Color.Transparent
                        ),
                        center = Offset(c.x - r * 0.35f, c.y - r * 0.35f),
                        radius = r * 0.95f
                    ),
                    radius = r,
                    center = c
                )

                // ---- 小さい強反射（キラッ）----
                val specA = 0.22f * charge
                if (specA > 0.001f) {
                    val sc = Offset(c.x - r * 0.45f, c.y - r * 0.55f)
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(Color.White.copy(alpha = specA), Color.Transparent),
                            center = sc,
                            radius = r * 0.35f
                        ),
                        radius = r * 0.35f,
                        center = sc
                    )
                }

                // ---- 縁の発光リング ----
                val ringA = 0.35f + 1.0f * charge
                if (ringA > 0.001f) {
                    val stroke = r * 0.22f
                    drawCircle(
                        color = Color.White.copy(alpha = ringA * 0.55f),
                        radius = r - stroke / 2f,
                        center = c,
                        style = Stroke(width = stroke)
                    )
                    drawCircle(
                        color = color.copy(alpha = ringA * 0.45f),
                        radius = r - stroke / 2f,
                        center = c,
                        style = Stroke(width = stroke * 0.6f)
                    )
                }
            }
        }
    }
}

/* -----------------------------
   星
------------------------------ */
private data class StarItem(
    val size: Dp,
    val endOffsetPx: Offset,   // 中心からの最終オフセット(px)
    val spinTurns: Float,
    val delayMs: Int
)

@Composable
private fun StarsBurstScatterLayer(
    center: Offset,
    show: Boolean,
    fadeOutTrigger: Boolean,
    modifier: Modifier = Modifier,
    resStar: Int,
    // それぞれの個数（3〜4推奨）
    bigCount: Int = 3,
    midCount: Int = 4,
    smallCount: Int = 4,
    // サイズ
    bigSize: Dp = 56.dp,
    midSize: Dp = 40.dp,
    smallSize: Dp = 28.dp,
    // “まばら”範囲（中心からの距離レンジ）
    radiusMinDp: Dp = 70.dp,
    radiusMaxDp: Dp = 150.dp,
    // 出現/回転時間
    flyMs: Int = 420
) {
    val valid = center != Offset.Unspecified && center.x.isFinite() && center.y.isFinite()
    if (!valid) return
    if (!show && !fadeOutTrigger) return

    val density = LocalDensity.current
    val rMinPx = with(density) { radiusMinDp.toPx() }
    val rMaxPx = with(density) { radiusMaxDp.toPx() }

    // ✅ D_STARS の開始ごとに配置を固定生成（チラつき防止）
    val seedKey = remember(show, center) {
        // show が true になったタイミングで変わるように
        if (show) (center.x.toInt() * 73856093) xor (center.y.toInt() * 19349663) xor 0x9E3779B9.toInt()
        else 0
    }

    val items: List<StarItem> = remember(seedKey) {
        if (seedKey == 0) emptyList()
        else {
            val rnd = Random(seedKey)

            fun makeItems(
                count: Int,
                size: Dp,
                baseTurns: Float,
                // サイズ別にレンジを変える（被りにくくする）
                rMin: Float,
                rMax: Float
            ): List<StarItem> {
                val placed = mutableListOf<Offset>() // 既に置いた停止位置
                val minSep = max(40f, with(density) { (size * 0.7f).toPx() }) // だいたいの最小間隔

                fun tryPickOffset(): Offset {
                    // 最大20回リトライ（近すぎたら再抽選）
                    repeat(20) {
                        val up = (-Math.PI / 2f).toFloat()

                        // ✅ 扇を少し広げる（±75°）←広がり増
                        val spread = Math.toRadians(75.0).toFloat()

                        // ✅ 中心を少しだけ“上に寄せた方向”へ（=左右対称のまま上寄り）
                        val ang = up + (rnd.nextFloat() * 2f - 1f) * spread

                        // ✅ 距離：外側が多めになる分布（sqrt）
                        val t = sqrt(rnd.nextFloat())
                        val r = rMin + (rMax - rMin) * t

                        // ✅ ジッター（少し増やして散らす）
                        val jitter = (rnd.nextFloat() * 2f - 1f) * 26f

                        var dx = cos(ang) * (r + jitter)
                        var dy = sin(ang) * (r + jitter)

                        // ✅ “もっと上に”バイアス（dy をさらにマイナス方向へ）
                        // これで全体が花の方へ寄る
                        dy -= (r * 0.18f)   // 0.12〜0.25で調整

                        val o = Offset(dx, dy)

                        // ✅ 既存と近すぎたら却下
                        val ok = placed.all { p ->
                            val ddx = p.x - o.x
                            val ddy = p.y - o.y
                            (ddx * ddx + ddy * ddy) >= (minSep * minSep)
                        }
                        if (ok) return o
                    }
                    // どうしても決まらなければそのまま（最後の手段）
                    return placed.lastOrNull()?.let { last ->
                        last + Offset(28f, -18f)
                    } ?: Offset(0f, -rMin)
                }

                return List(count) { i ->
                    val end = tryPickOffset()
                    placed.add(end)

                    StarItem(
                        size = size,
                        endOffsetPx = end,
                        spinTurns = baseTurns + rnd.nextFloat() * 1.2f,
                        delayMs = rnd.nextInt(0, 160) + i * 10
                    )
                }
            }

            buildList {
                // 大：外側
                addAll(makeItems(bigCount, bigSize, baseTurns = 2.0f, rMin = rMinPx * 0.95f, rMax = rMaxPx * 1.20f))
                // 中：中間
                addAll(makeItems(midCount, midSize, baseTurns = 1.8f, rMin = rMinPx * 0.80f, rMax = rMaxPx * 1.05f))
                // 小：内側
                addAll(makeItems(smallCount, smallSize, baseTurns = 1.4f, rMin = rMinPx * 0.60f, rMax = rMaxPx * 0.90f))
            }
        }
    }

    // 全体フェード（Successと同期）
    val groupAlpha = remember { Animatable(0f) }
    LaunchedEffect(show) {
        if (show) {
            groupAlpha.snapTo(0f)
            groupAlpha.animateTo(1f, tween(120))
        }
    }
    LaunchedEffect(fadeOutTrigger) {
        if (fadeOutTrigger) {
            groupAlpha.animateTo(0f, tween(160))
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        items.forEachIndexed { idx, it ->
            key(idx) {
                val prog = remember { Animatable(0f) }     // 0..1（中心→終点）
                val rot = remember { Animatable(0f) }      // degree

                LaunchedEffect(show) {
                    if (!show) return@LaunchedEffect
                    delay(it.delayMs.toLong())

                    prog.snapTo(0f)
                    rot.snapTo(0f)

                    val moveJob = launch {
                        prog.animateTo(1f, tween(flyMs, easing = FastOutSlowInEasing))
                    }
                    val rotJob = launch {
                        rot.animateTo(360f * it.spinTurns, tween(flyMs, easing = FastOutSlowInEasing))
                    }

                    moveJob.join()
                    rotJob.join()

                    // ✅ ピタッと止める（360の倍数にスナップ）
                    val snapped = (rot.value / 360f).roundToInt() * 360f
                    rot.snapTo(snapped)
                }

                val sizePx = with(density) { it.size.toPx() }
                val x = center.x + it.endOffsetPx.x * prog.value - sizePx / 2f
                val y = center.y + it.endOffsetPx.y * prog.value - sizePx / 2f

                Image(
                    painter = painterResource(resStar),
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer {
                            alpha = groupAlpha.value
                            rotationZ = rot.value
                            translationX = x
                            translationY = y
                        }
                        .size(it.size)
                )
            }
        }
    }
}

/* -----------------------------
   録音ボタン
------------------------------ */
@Composable
private fun MicOrRecordingButton(
    isActive: Boolean,
    accent: Color,
    enabled: Boolean,
    content: CenterButtonContent,
    onClick: () -> Unit
) {
    val bgBrushOrNull = if (!isActive) {
        Brush.linearGradient(listOf(Color(0xFF7A2DFF), Color(0xFF4FC3F7)))
    } else null

    // ✅ 通常170dp、録音中は約2/3
    val buttonSize = when (content) {
        CenterButtonContent.MIC -> 170.dp
        CenterButtonContent.BARS -> 113.dp   // 170 * 2/3 = 約113
        CenterButtonContent.CHECK -> 170.dp
        CenterButtonContent.DOTS -> 170.dp
    }

    val iconSize = when (content) {
        CenterButtonContent.MIC -> 96.dp
        CenterButtonContent.BARS -> 56.dp
        CenterButtonContent.CHECK -> 56.dp
        CenterButtonContent.DOTS -> 56.dp
    }

    val baseScale by animateFloatAsState(
        targetValue = if (isActive) 1.0f else 1.0f, // 録音中だけ膨らませない
        animationSpec = tween(220, easing = FastOutSlowInEasing),
        label = "btnBaseScale"
    )

    Box(
        modifier = Modifier
            .size(buttonSize)
            .graphicsLayer {
                scaleX = baseScale
                scaleY = baseScale
            }
            .shadow(24.dp, CircleShape, clip = false)
            .then(
                if (isActive) Modifier.background(Color.White, CircleShape)
                else Modifier.background(bgBrushOrNull!!, CircleShape)
            )
            .clip(CircleShape)
            .then(if (enabled) Modifier.clickable { onClick() } else Modifier),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = content == CenterButtonContent.MIC,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Icon(
                painter = painterResource(R.drawable.play),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(iconSize)
                    .offset(x = 6.dp)
            )
        }

        AnimatedVisibility(
            visible = content == CenterButtonContent.BARS,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(Modifier.size(iconSize)) {
                RecordingBarsWave(color = accent)
            }
        }

        AnimatedVisibility(
            visible = content == CenterButtonContent.CHECK,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(Modifier.size(iconSize)) {
                CheckMarkBarsIcon(color = accent)
            }
        }
    }
}

@Composable
private fun RecordingBarsWave(color: Color) {
    val phase = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            phase.animateTo(1f, tween(900, easing = LinearEasing))
            phase.snapTo(0f)
        }
    }

    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        WaveBar(index = 0, phase = phase.value, color = color)
        WaveBar(index = 1, phase = phase.value, color = color)
        WaveBar(index = 2, phase = phase.value, color = color)
    }
}

@Composable
private fun WaveBar(index: Int, phase: Float, color: Color) {
    val p = (phase + index * 0.16f) * (2f * Math.PI).toFloat()
    val height = (24f + (46f * ((sin(p) + 1f) / 2f))).dp
    val y = (8f * sin(p + 1.1f)).dp

    Box(
        modifier = Modifier
            .offset(y = y)
            .width(10.dp)
            .height(height)
            .clip(RoundedCornerShape(999.dp))
            .background(color)
    )
}

@Composable
private fun CheckMarkBarsIcon(color: Color) {
    val stroke = 10.dp
    Canvas(modifier = Modifier.size(56.dp)) {
        val w = size.width
        val h = size.height

        val path = Path().apply {
            moveTo(w * 0.18f, h * 0.55f)
            lineTo(w * 0.42f, h * 0.74f)
            lineTo(w * 0.82f, h * 0.30f)
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = stroke.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}

/* -----------------------------
   キャンセル
------------------------------ */
@Composable
private fun CancelButtonLayer(
    show: Boolean,
    onCancel: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(100f),
        contentAlignment = Alignment.BottomCenter
    ) {
        AnimatedVisibility(
            visible = show,
            enter = slideInVertically { it } + fadeIn(tween(180)),
            exit = slideOutVertically { it } + fadeOut(tween(120))
        ) {
            val shape = RoundedCornerShape(999.dp)
            Box(
                modifier = Modifier
                    .padding(bottom = 18.dp)
                    .shadow(14.dp, shape, clip = false)
                    .background(Color.White, shape)
                    .padding(2.dp)
            ) {
                OutlinedButton(
                    onClick = onCancel,
                    shape = shape,
                    border = BorderStroke(2.dp, Color(0xFF4FC3F7)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF4FC3F7)
                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp)
                ) {
                    Text("キャンセル", fontFamily = KosugiMaru)
                }
            }
        }
    }
}

/* -----------------------------
   ヘッダー（フェイズで文言変化 / A_IDLEだけハンバーガー）
------------------------------ */
@Composable
private fun HeaderArea(
    phase: Phase,
    onHamburger: () -> Unit,
    modifier: Modifier = Modifier
) {
    val ui = remember(phase) { headerForPhase(phase) }
    // ✅ タイプライターの“リセットキー”をフェイズのグループで固定する
    val typewriterKey: Any = when (phase) {
        Phase.C_COLOR_EXPAND, Phase.C_PANEL_DISMISS -> "C_WORDS_GROUP"
        Phase.C_ORB_TO_VASE, Phase.D_STARS -> "V_REMEMBER_GROUP"
        else -> phase
    }
    val isIdle = phase == Phase.A_IDLE

    val brush = if (isIdle) {
        Brush.horizontalGradient(listOf(Color(0xFF7A2DFF), Color(0xFF4FC3F7)))
    } else {
        Brush.horizontalGradient(listOf(Color.White, Color.White))
    }

    val textColor = if (isIdle) Color.White else Color(0xFF222222)

    val unifiedStyle = androidx.compose.ui.text.TextStyle(
        color = textColor,
        fontFamily = KosugiMaru,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )

    val reserveEnd = if (isIdle) 72.dp else 12.dp   // ✅ Aだけ右を空ける
    val align = if (isIdle) Alignment.CenterStart else Alignment.Center
    val hAlign = if (isIdle) Alignment.Start else Alignment.CenterHorizontally

    Box(
        modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(brush)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        // ✅ 文字用の領域は “幅いっぱい” を確保する
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = reserveEnd)          // ✅ ここが超重要：非Idleは狭めない
                .align(align)
        ) {
            Column(horizontalAlignment = hAlign) {

                if (isIdle) {
                    // ✅ Aだけは即表示＆左寄り
                    Text(ui.title, style = unifiedStyle, maxLines = 1, softWrap = false, overflow = TextOverflow.Clip)
                    Spacer(Modifier.height(2.dp))
                    Text(ui.subtitle, style = unifiedStyle.copy(fontWeight = FontWeight.Medium),
                        maxLines = 1, softWrap = false, overflow = TextOverflow.Clip)
                } else {
                    // ✅ それ以外はタイプライター（1行固定）
                    TypewriterText(
                        text = ui.title,
                        runKey = typewriterKey,
                        style = unifiedStyle
                    )
                    Spacer(Modifier.height(2.dp))
                    TypewriterText(
                        text = ui.subtitle,
                        runKey = typewriterKey,
                        style = unifiedStyle.copy(fontWeight = FontWeight.Medium)
                    )
                }
            }
        }

        // ✅ ハンバーガーは「文字より下」に配置（右下寄せ）
        if (isIdle) {
            IconButton(
                onClick = onHamburger,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 2.dp, bottom = 2.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu",
                    tint = Color.White
                )
            }
        }
    }
}

private data class HeaderUi(val title: String, val subtitle: String)

private fun headerForPhase(phase: Phase): HeaderUi {
    return when (phase) {
        Phase.A_IDLE -> HeaderUi(
            title = "Voice Diary",
            subtitle = "あなたの声で記録する日記"
        )

        Phase.B_RECORDING_FILL -> HeaderUi(
            title = "思った事を声にして花に水をあげよう",
            subtitle = ""
        )

        Phase.B_WATERING_DRAIN -> HeaderUi(
            title = "花に水をあげています。",
            subtitle = ""
        )

        Phase.B_SPARKLE -> HeaderUi(
            title = "あなたの想いがしみこんでいきます…",
            subtitle = ""
        )

        Phase.C_PANEL_REVEAL -> HeaderUi(
            title = "あなたの今日の気分をタップして",
            subtitle = ""
        )

        Phase.C_COLOR_EXPAND,
        Phase.C_PANEL_DISMISS -> HeaderUi(
            title = "あなたの言葉と感情を花が覚えています",
            subtitle = ""
        )

        Phase.C_ORB_TO_VASE,
        Phase.D_STARS -> HeaderUi(
            title = "",
            subtitle = ""
        )

        Phase.D_SUCCESS -> HeaderUi(
            title = "記されました！",
            subtitle = ""
        )

        Phase.BACK_TO_A -> HeaderUi(
            title = "",
            subtitle = ""
        )
    }
}



/* -----------------------------
   util
------------------------------ */
private fun Offset.isValidOffset(): Boolean =
    this != Offset.Unspecified && this.x.isFinite() && this.y.isFinite()

private data class Anchor(val x: Float, val y: Float) // 0..1

private val VaseBottomAnchor = Anchor(0.5f, 0.98f)
private val VaseMouthAnchor  = Anchor(0.5f, 0.33f)
private val FlowerStemAnchor = Anchor(0.5f, 0.90f)

private fun off(x: Float, y: Float) = Offset(x, y)
private fun add(a: Offset, b: Offset) = Offset(a.x + b.x, a.y + b.y)
private fun mul(a: Offset, s: Float) = Offset(a.x * s, a.y * s)


@Stable
data class FlySpec(
    val durationMs: Int = 1200,
    val easing: Easing = FastOutSlowInEasing,
    val endPullPx: Float = 10f,
    val endPullPow: Float = 1.7f
)

@Composable
fun rememberFlyOrbState(): FlyOrbState = remember { FlyOrbState() }

class FlyOrbState {
    private val t = Animatable(0f)

    var start by mutableStateOf(Offset.Unspecified)
    var end by mutableStateOf(Offset.Unspecified)

    fun reset() {
        start = Offset.Unspecified
        end = Offset.Unspecified
        // t は 1 のままでもいいけど、念のため戻すなら
        // （suspend が必要になるので snapTo はここではしない）
    }

    fun isAnimating(): Boolean =
        start.isValidOffset() && end.isValidOffset() && t.isRunning

    fun currentOffset(spec: FlySpec): Offset {
        val s = start
        val e = end
        if (!s.isValidOffset() || !e.isValidOffset()) return Offset.Unspecified

        val tt = t.value.coerceIn(0f, 1f)
        val eased = spec.easing.transform(tt)

        val base = lerp(s, e, eased)

        // 終盤の“吸い込み”
        val pull = (tt).pow(spec.endPullPow) * spec.endPullPx
        val vx = e.x - base.x
        val vy = e.y - base.y
        val len = hypot(vx, vy).coerceAtLeast(1f)

        return Offset(base.x + vx / len * pull, base.y + vy / len * pull)

    }

    suspend fun animate(startPx: Offset, endPx: Offset, spec: FlySpec) {
        start = startPx
        end = endPx
        t.snapTo(0f)
        t.animateTo(1f, tween(spec.durationMs, easing = spec.easing))
    }

    private fun lerp(a: Offset, b: Offset, t: Float): Offset =
        Offset(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t)
}

@Composable
private fun TypewriterText(
    text: String,
    runKey: Any,
    modifier: Modifier = Modifier,
    perCharMs: Long = 40L,     // 速さ（小さいほど速い）
    minTotalMs: Long = 420L,   // 最低表示時間
    maxTotalMs: Long = 1400L,   // 最長表示時間（長文でもダラダラしない）
    style: androidx.compose.ui.text.TextStyle
) {
    var shownCount by remember(runKey, text) { mutableStateOf(0) }

    LaunchedEffect(runKey, text) {
        shownCount = 0
        if (text.isEmpty()) return@LaunchedEffect

        val total = (text.length * perCharMs).coerceIn(minTotalMs, maxTotalMs)
        val step = (total / text.length).coerceAtLeast(10L)

        while (shownCount < text.length) {
            delay(step)
            shownCount++
        }
    }

    Text(
        text = text.take(shownCount),
        modifier = modifier,
        style = style,
        maxLines = 1,
        softWrap = false,
        overflow = TextOverflow.Clip
    )
}

@Composable
private fun RealisticPourWaterLayer(
    pos: Offset,
    sizePx: Float,
    spoutLocal: Offset,
    tiltDeg: Float,
    target: Offset,
    pour: Float
) {
    val pourAlpha = pour.coerceIn(0f, 1f)
    if (pourAlpha <= 0.001f) return

    val wavePhase by animateFloatAsState(
        targetValue = if (pour > 0f) 1f else 0f,
        animationSpec = tween(220, easing = LinearEasing),
        label = "waterWavePhase"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val sp = approximateRotatedPoint(
            origin = pos + Offset(sizePx * 0.72f, sizePx * 0.58f),
            p = pos + spoutLocal,
            deg = tiltDeg
        )

        val end = target

        val dx = end.x - sp.x
        val dy = end.y - sp.y
        val len = hypot(dx, dy).coerceAtLeast(1f)
        val nx = -dy / len
        val ny = dx / len

        val thickness = 16f * pourAlpha
        val wobble = 6f * pourAlpha

        val c1 = Offset(
            x = sp.x + dx * 0.28f + nx * wobble,
            y = sp.y + dy * 0.18f
        )
        val c2 = Offset(
            x = sp.x + dx * 0.70f - nx * wobble,
            y = sp.y + dy * 0.78f
        )

        // 外側の柔らかい帯
        drawPath(
            path = Path().apply {
                moveTo(sp.x - nx * thickness, sp.y - ny * thickness)
                cubicTo(
                    c1.x - nx * thickness * 0.9f, c1.y - ny * thickness * 0.9f,
                    c2.x - nx * thickness * 0.65f, c2.y - ny * thickness * 0.65f,
                    end.x - nx * thickness * 0.40f, end.y - ny * thickness * 0.40f
                )
                lineTo(end.x + nx * thickness * 0.40f, end.y + ny * thickness * 0.40f)
                cubicTo(
                    c2.x + nx * thickness * 0.65f, c2.y + ny * thickness * 0.65f,
                    c1.x + nx * thickness * 0.9f, c1.y + ny * thickness * 0.9f,
                    sp.x + nx * thickness, sp.y + ny * thickness
                )
                close()
            },
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0x99DDF4FF),
                    Color(0xCC8FD8FF),
                    Color(0x88BEEBFF)
                )
            ),
            alpha = 0.75f * pourAlpha
        )

        // 中央の芯
        val corePath = Path().apply {
            moveTo(sp.x, sp.y)
            cubicTo(c1.x, c1.y, c2.x, c2.y, end.x, end.y)
        }

        drawPath(
            path = corePath,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.65f * pourAlpha),
                    Color(0xFFAEE6FF).copy(alpha = 0.95f * pourAlpha),
                    Color(0xFF6FC8FF).copy(alpha = 0.75f * pourAlpha)
                ),
                start = sp,
                end = end
            ),
            style = Stroke(
                width = thickness * 0.9f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )

        // ハイライト細線
        drawPath(
            path = corePath,
            color = Color.White.copy(alpha = 0.55f * pourAlpha),
            style = Stroke(
                width = thickness * 0.28f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )

        // 水滴
        repeat(4) { i ->
            val t = 0.22f + i * 0.18f
            val px = sp.x + dx * t + nx * sin((t + wavePhase) * 10f) * 4f
            val py = sp.y + dy * t + ny * sin((t + wavePhase) * 10f) * 4f

            drawCircle(
                color = Color(0xFFAEE6FF).copy(alpha = 0.55f * pourAlpha),
                radius = 3.5f + i,
                center = Offset(px, py)
            )
            drawCircle(
                color = Color.White.copy(alpha = 0.45f * pourAlpha),
                radius = 1.6f + i * 0.2f,
                center = Offset(px - 1.5f, py - 1.5f)
            )
        }
    }
}

@Composable
private fun WateringCanAnimLayer(
    canBackRes: Int,
    canFrontRes: Int,
    fill: Float,
    tiltDeg: Float,
    pour: Float,
    rootW: Float,
    rootH: Float,
    target: Offset,
    modifier: Modifier = Modifier
) {
    if (rootW <= 0f || rootH <= 0f) return

    val canSize = 160.dp
    val density = LocalDensity.current
    val sizePx = with(density) { canSize.toPx() }

    val pos = Offset(
        x = (target.x + sizePx * 0.55f).coerceIn(0f, rootW - sizePx),
        y = (target.y - sizePx * 1.85f).coerceIn(0f, rootH - sizePx)
    )

    val spoutLocal = Offset(sizePx * 0.13f, sizePx * 0.40f)

    Box(modifier = modifier.fillMaxSize()) {

        // =========================
        // ① 背面
        // =========================
        Image(
            painter = painterResource(canBackRes),
            contentDescription = null,
            modifier = Modifier
                .offset { IntOffset(pos.x.roundToInt(), pos.y.roundToInt()) }
                .size(canSize)
                .graphicsLayer {
                    rotationZ = tiltDeg
                    transformOrigin = TransformOrigin(0.72f, 0.58f)
                }
        )

        // =========================
        // ② 水（中身）
        // =========================
        Canvas(
            modifier = Modifier
                .offset { IntOffset(pos.x.roundToInt(), pos.y.roundToInt()) }
                .size(canSize)
                .graphicsLayer {
                    rotationZ = tiltDeg
                    transformOrigin = TransformOrigin(0.72f, 0.58f)
                }
        ) {
            val f = fill.coerceIn(0f, 1f)

            val bodyLeft = size.width * 0.28f
            val bodyRight = size.width * 0.72f
            val bodyTop = size.height * 0.34f
            val bodyBottom = size.height * 0.80f

            val bodyPath = Path().apply {
                moveTo(size.width * 0.32f, size.height * 0.35f)

                quadraticBezierTo(
                    size.width * 0.20f, size.height * 0.55f,
                    size.width * 0.30f, size.height * 0.80f
                )

                lineTo(size.width * 0.70f, size.height * 0.80f)

                quadraticBezierTo(
                    size.width * 0.80f, size.height * 0.55f,
                    size.width * 0.68f, size.height * 0.35f
                )

                close()
            }

            clipPath(bodyPath) {
                val waterTop = bodyBottom - (bodyBottom - bodyTop) * f

                // 水グラデーション
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE6F7FF).copy(alpha = 0.9f),
                            Color(0xFF9ED8FF).copy(alpha = 0.75f),
                            Color(0xFF5FBFFF).copy(alpha = 0.8f)
                        ),
                        startY = waterTop,
                        endY = bodyBottom
                    ),
                    topLeft = Offset(bodyLeft, waterTop),
                    size = Size(bodyRight - bodyLeft, bodyBottom - waterTop)
                )

                // 水面ハイライト
                drawLine(
                    color = Color.White.copy(alpha = 0.65f),
                    start = Offset(bodyLeft + 4f, waterTop),
                    end = Offset(bodyRight - 4f, waterTop),
                    strokeWidth = 3f,
                    cap = StrokeCap.Round
                )

                // 内部反射
                drawRect(
                    color = Color.White.copy(alpha = 0.08f),
                    topLeft = Offset(bodyLeft, waterTop),
                    size = Size((bodyRight - bodyLeft) * 0.4f, bodyBottom - waterTop)
                )
            }
        }

        // =========================
        // ③ 前面（フチ）
        // =========================
        Image(
            painter = painterResource(canFrontRes),
            contentDescription = null,
            modifier = Modifier
                .offset { IntOffset(pos.x.roundToInt(), pos.y.roundToInt()) }
                .size(canSize)
                .graphicsLayer {
                    rotationZ = tiltDeg
                    transformOrigin = TransformOrigin(0.72f, 0.58f)
                }
        )

        // =========================
        // ④ 水流（リアル版）
        // =========================
        RealisticPourWaterLayer(
            pos = pos,
            sizePx = sizePx,
            spoutLocal = spoutLocal,
            tiltDeg = tiltDeg,
            target = target,
            pour = pour
        )
    }
}

private fun approximateRotatedPoint(origin: Offset, p: Offset, deg: Float): Offset {
    val rad = Math.toRadians(deg.toDouble())
    val s = sin(rad).toFloat()
    val c = cos(rad).toFloat()
    val dx = p.x - origin.x
    val dy = p.y - origin.y
    return Offset(
        x = origin.x + (dx * c - dy * s),
        y = origin.y + (dx * s + dy * c)
    )
}