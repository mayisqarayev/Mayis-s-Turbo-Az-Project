package com.turboaz.dto.response

import java.time.LocalDate

data class CarPropertyResponseDto(
    var carCity: String?,
    var carMark: String?,
    var carModel: String?,
    var carDepartureDate: LocalDate?,
    var carBanType: String?,
    var carColor: String?,
    var carEngine: String?,
    var carFuelType: String?,
    var carMarch: String?,
    var carAccelerationBoxType: String?,
    var carTransmitterType: String?,
    var carIsNew: Boolean?,
)