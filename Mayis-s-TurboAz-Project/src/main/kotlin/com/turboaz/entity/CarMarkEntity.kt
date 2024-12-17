package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

@Entity
data class CarMarkEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var carMarkName: String?,
    var carMarkStatus: Boolean?
)
{
    constructor(): this(null, null, null)
}
