package com.turboaz.dto.request

import java.time.LocalDate

data class AddNewCarPropertyRequestDto(
    var fkCarCityId: String?,
    var fkCarMarkId: String?,
    var fkCarModelId: String?,
    var carDepartureDate: LocalDate?,
    var fkCarBanTypeId: String?,
    var fkCarColorId: String?,
    var carEngine: String?,
    var fkCarFuelTypeId: String?,
    var carMarch: String?,
    var fkCarAccelerationBoxTypeId: String?,
    var fkCarTransmitterTypeId: String?,
    var carIsNew: Boolean?,
)
