package com.ebi_tarou.shinysupporter.domain.model

data class ObtainedNouhau(
    val id: Int,
    val nouhauNoteId: Int,
    private val nouhau: Nouhau,
    var level: Int? = null,
) {
    val name: String get() = nouhau.name
    val caption: String get() = nouhau.caption
    val canTakeOver: Boolean get() = nouhau.canTakeOver
    val dropArea: String get() = nouhau.dropArea
    val dropConditionCaption: String get() = nouhau.dropConditionCaption
}
