package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.Builder
import lombok.Data
import lombok.experimental.FieldDefaults
import java.time.LocalDate

@Entity
data class CarPropertyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
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
    var carPropertyStatus: Boolean?,
)
{
    constructor(): this(null, null, null, null, null,null,null,null,null,null,null,null,null,null)
}
