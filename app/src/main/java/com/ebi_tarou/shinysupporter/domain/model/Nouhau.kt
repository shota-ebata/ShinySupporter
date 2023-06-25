package com.ebi_tarou.shinysupporter.domain.model

sealed interface Nouhau {
    val id: Long
    val name: String
    val caption: String
    val minLevel: Int
    val maxLevel: Int
}

data class AtamaNouhau(
    override val id: Long,
    override val name: String,
    override val caption: String,
    override val minLevel: Int,
    override val maxLevel: Int
): Nouhau



interface QuickEffectNouhau: Nouhau {

}

/**
 * ポイント消費するノウハウ
 */
interface PointSpentNouhau: Nouhau {
    val singingPoint: Int
    val stabilityPoint: Int
    val artisticPoint: Int
    val focusPoint: Int
    val unityPoint: Int
}

interface AbilityNouhau: PointSpentNouhau {

}