package com.turboaz.dto.request

data class CreateAccountRequestDto(
    var accountName: String?,
    var accountPhoneNumber: String?,
    var fkUserId: String?
)
