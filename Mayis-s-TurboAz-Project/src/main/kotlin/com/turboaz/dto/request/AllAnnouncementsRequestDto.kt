package com.turboaz.dto.request

data class AllAnnouncementsRequestDto(
    val pageNumber: Int?,
    val pageSize: Int?,
    val accountId: String?
)
