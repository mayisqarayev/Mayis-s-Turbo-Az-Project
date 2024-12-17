package com.turboaz.dto.request

import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
data class AddMarkRequestDto(
    val markName: String?
)
