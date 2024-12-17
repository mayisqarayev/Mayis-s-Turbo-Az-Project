package com.turboaz.dto.request

data class AccountDetailsRequestDto(
    val id: String?,
    var accountName: String? = "Account name Not Defined",
    var accountPhoneNumber: String? = "000-000-00-00",
    var accountLocation: String? = "Account Location Not Defined",
    var accountDescription: String? = "Account Description Not Defined",
    var accountProfilePhotoUrl: String? = "Account Profile Photo Not Defined",
)