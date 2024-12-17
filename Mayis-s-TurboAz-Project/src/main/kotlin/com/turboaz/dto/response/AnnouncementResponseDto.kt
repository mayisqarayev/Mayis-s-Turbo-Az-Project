package com.turboaz.dto.response

import java.math.BigDecimal
import java.time.LocalDate


data class  AnnouncementResponseDto(
    var announcementName: String?,
    var announcementPrice: BigDecimal?,
    var announcementIsSelected: Boolean?,
    var announcementDescription: String?,
    var announcementNumber: String?,
    var deploymentDate: LocalDate?,
    var countOfView: BigDecimal?,
    var account: AccountResponseDto?,
    var carProperty: CarPropertyResponseDto?,
    var model: ModelResponseDto?
)
