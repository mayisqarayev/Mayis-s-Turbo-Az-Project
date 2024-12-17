package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class AnnouncementNumberEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var announcementNumber: String?,
    var announcementNumberStatus: Boolean?,

    var fkAnnouncementId: String?
)
{
    constructor(): this(null, null, null, null)
}
