package com.turboaz.dto.request

import java.math.BigDecimal
import java.time.LocalDate

data class AddNewAnnouncementRequestDto(
    var announcementPrice: BigDecimal?,
    var announcementDescription: String?,
    var announcementNumber: String?,

    var fkModelId: String?,
    var fkMarkId: String?,
    var fkCarCityId: String?,
    var carDepartureDate: LocalDate?,
    var fkCarBanTypeId: String?,
    var fkCarColorId: String?,
    var carEngine: String?,
    var fkCarFuelTypeId: String?,
    var carMarch: String?,
    var fkCarAccelerationBoxTypeId: String?,
    var fkCarTransmitterTypeId: String?,
    var carIsNew: Boolean?,
    var fkAccountId: String?,
)
