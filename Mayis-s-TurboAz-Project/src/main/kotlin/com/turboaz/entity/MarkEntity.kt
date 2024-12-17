package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.FieldDefaults

@Entity
data class MarkEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var markName: String?,
    var markStatus: Boolean?
)
{
    constructor(): this(null, null, null)
}