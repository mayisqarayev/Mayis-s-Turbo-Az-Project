package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.Builder
import lombok.Data
import lombok.experimental.FieldDefaults

@Entity
data class ImageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var imageUrl: String?,
    var imageStatus: Boolean?,

    var fkAnnouncementId: String?
)
{
    constructor(): this(null, null, null, null)
}