package com.turboaz.mapper

import com.turboaz.dto.request.AddMarkRequestDto
import com.turboaz.dto.response.AllMarksResponseDto
import com.turboaz.dto.response.MarkResponseDto
import com.turboaz.dto.response.MarkResponseDtoForModelResponseDto
import com.turboaz.entity.MarkEntity
import org.springframework.stereotype.Component

@Component
class MarkConverter {

    fun toAllMarksResponseDtoFromEntity(markEntity: MarkEntity?): AllMarksResponseDto?
    = AllMarksResponseDto(markEntity!!.markName)


    fun toEntityFromAddMarkRequestDto(requestDto: AddMarkRequestDto?): MarkEntity?
    {
        val markEntity = MarkEntity()
        markEntity.markName = requestDto!!.markName
        markEntity.markStatus = true

        return markEntity
    }

    fun toMarkResponseDtoForModelResponseDtoFromEntity(markEntity: MarkEntity?): MarkResponseDtoForModelResponseDto?
    = MarkResponseDtoForModelResponseDto(markEntity!!.markName)

    fun toMarkResponseDtoFromEntity(entity: MarkEntity?): MarkResponseDto?
    {
        return MarkResponseDto(entity!!.markName)
    }

}