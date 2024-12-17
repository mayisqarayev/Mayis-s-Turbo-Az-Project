package com.turboaz.dto.response

import java.math.BigDecimal
import java.time.LocalDate

data class AllAnnouncementsResponseDto(
    val announcementName: String?,
    val announcementPrice: BigDecimal?,
    val announcementIsSelected: Boolean?,
    val deploymentDate: LocalDate?,
)