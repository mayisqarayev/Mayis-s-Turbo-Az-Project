package com.turboaz.dto.response

import lombok.AccessLevel
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.FieldDefaults

data class AllMarksResponseDto(
    val markName: String?
)