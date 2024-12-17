package com.turboaz.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.Builder
import lombok.Data
import lombok.experimental.FieldDefaults
import java.math.BigDecimal

@Entity
data class AccountEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var accountName: String?,
    var accountStatus: Boolean?,
    var accountPhoneNumber: String?,
    var accountLocation: String?,
    var accountDescription: String?,
    var accountProfilePhotoUrl: String?,

    var fkUserId: String?
)
{
    constructor(): this(null, null, null, null, null, null, null, null)
}