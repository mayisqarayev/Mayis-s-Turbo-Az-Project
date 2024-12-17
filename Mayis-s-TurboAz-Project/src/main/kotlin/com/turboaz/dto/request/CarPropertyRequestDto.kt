package com.turboaz.dto.request

import java.time.LocalDate

data class CarPropertyRequestDto(
    val fkModelId: String?,
    val fkMarkId: String?,
    val fkCarCityId: String?,
    val carDepartureDate: LocalDate?,
    val fkCarBanTypeId: String?,
    val fkCarColorId: String?,
    val carEngine: String?,
    val fkCarFuelTypeId: String?,
    val carMarch: String?,
    val fkCarAccelerationBoxTypeId: String?,
    val fkCarTransmitterTypeId: String?,
    val carIsNew: Boolean?
)
