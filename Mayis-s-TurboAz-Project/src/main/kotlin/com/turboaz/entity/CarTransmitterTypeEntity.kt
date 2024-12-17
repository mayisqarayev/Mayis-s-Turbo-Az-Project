package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

@Entity
data class CarTransmitterTypeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var carTransmitterTypeName: String?,
    var carTransmitterTypeStatus: Boolean?
)
{
    constructor(): this(null, null, null)
}
