package com.turboaz.dto.request
import java.math.BigDecimal


data class UpdateAnnouncementRequestDto(
    val id: String?,
    val announcementPrice: BigDecimal?,
    val announcementDescription: String?,
    val carProperty: CarPropertyRequestDto?,
)
