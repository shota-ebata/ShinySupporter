package com.ebi_tarou.shinysupporter.domain.model

import com.ebi_tarou.shinysupporter.domain.constant.Idol
import java.time.LocalDateTime

data class NouhauNote(
    val id: Int,
    val idol: Idol,
    val acquiredNouhauList: List<AcquiredNouhau>,
    val acquiredDateTime: LocalDateTime
)
