package com.turboaz.dto.request

import lombok.Data


data class AddModelRequestDto(
    val modelName: String?,
    val fkMarkId: String?
)