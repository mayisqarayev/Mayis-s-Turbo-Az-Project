package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class AnnouncementEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String?,
        var announcementName: String?,
        var announcementPrice: BigDecimal?,
        var announcementIsSelected: Boolean?,
        var announcementDescription: String?,
        var announcementNumber: String?,
        var deploymentDate: LocalDate?,
        var countOfView: BigDecimal?,
        var announcementStatus: Boolean?,

        var fkAccountId: String?,
        var fkCarPropertyId: String?,
        var fkModelId: String?
)
{
        constructor(): this(null, null, null, null,null,null,null,null,null,null,null,null)
}