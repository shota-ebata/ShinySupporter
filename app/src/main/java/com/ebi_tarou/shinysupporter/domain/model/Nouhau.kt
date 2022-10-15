package com.ebi_tarou.shinysupporter.domain.model

data class Nouhau(
    val id: Int,
    val name: String,
    val caption: String,
    val canTakeOver: Boolean,
    val dropArea: String,
    val dropConditionCaption: String
)