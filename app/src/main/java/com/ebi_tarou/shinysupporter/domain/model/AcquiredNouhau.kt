package com.ebi_tarou.shinysupporter.domain.model

data class AcquiredNouhau(
    val id: Long,
    val nouhau: Nouhau,
    val level: Int? = null,
) {
    val name: String get() = nouhau.name
    val caption: String get() = nouhau.caption
}