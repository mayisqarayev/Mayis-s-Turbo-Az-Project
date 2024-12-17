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
data class ReportEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var reportText: String?,
    var reportStatus: Boolean?,

    var fkReporterId: String?,
    var fkReportedId: String?
)
{
    constructor(): this(null, null, null, null, null)
}
