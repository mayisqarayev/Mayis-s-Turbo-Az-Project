package com.turboaz.dto.response

data class AllAnnouncementsPageResponseDto(
    val totalElements: Long?,
    val totalPages: Long?,
    val isEmpty: Boolean?,
    val content: List<AllAnnouncementsResponseDto?>?
)
