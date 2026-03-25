package com.example.chronos.ui.assets

import com.example.chronos.R

object AssetCatalog {
    data class Anchor(val x: Float, val y: Float)

    data class VaseAsset(
        val resId: Int,
        val mouthAnchor: Anchor,
        val bottomAnchor: Anchor
    )

    data class FlowerAsset(
        val resId: Int,
        val stemAnchor: Anchor
    )

    fun vase(id: String): VaseAsset {
        return when(id) {
            "default" -> VaseAsset(
                resId = R.drawable.uekihaci1_safe,
                mouthAnchor = Anchor(0.5f, 0.32f),
                bottomAnchor = Anchor(0.5f, 0.98f)
            )
            else -> error("unknown vase")
        }
    }

    fun flower(id: String): FlowerAsset {
        return when(id) {
            "lily" -> FlowerAsset(
                resId = R.drawable.flower_lily,
                stemAnchor = Anchor(0.5f, 0.90f)
            )
            else -> error("unknown flower")
        }
    }

    // -----------------------------
    // Flowers (Free 15)
    // -----------------------------
    val flowers: Map<String, Int> = mapOf(
        "lily" to R.drawable.flower_lily,
        "tulip" to R.drawable.flower_tulip,
        "gerbera" to R.drawable.flower_gerbera,
        "lavender" to R.drawable.flower_lavender,
        "daisy" to R.drawable.flower_daisy,
        "babysbreath" to R.drawable.flower_babysbreath,
        "sunflower" to R.drawable.flower_sunflower,
        "marguerite" to R.drawable.flower_marguerite,
        "pansy" to R.drawable.flower_pansy,
        "nemophila" to R.drawable.flower_nemophila,
        "poppy" to R.drawable.flower_poppy,
        "carnation" to R.drawable.flower_carnation,
        "freesia" to R.drawable.flower_freesia,
        "anemone" to R.drawable.flower_anemone,
        "rosamosucarta" to R.drawable.flower_rosamosucarta
    )

    // -----------------------------
    // Pots / Vases
    //  - `uekihaci.png` にリネームしてある前提
    // -----------------------------
    val vases: Map<String, Int> = mapOf(
        "uekihaci" to R.drawable.uekihaci1_safe
    )

    fun flowerRes(id: String): Int =
        flowers[id] ?: R.drawable.flower_lily

    fun vaseRes(id: String): Int =
        vases[id] ?: R.drawable.uekihaci1_safe
}

