package com.turboaz.mapper

import com.turboaz.dto.request.AddModelRequestDto
import com.turboaz.dto.response.AllModelsResponseDto
import com.turboaz.dto.response.ModelResponseDto
import com.turboaz.entity.ModelEntity
import com.turboaz.service.MarkService
import org.springframework.stereotype.Component

@Component
class ModelConverter(private val markService: MarkService) {

    fun toAllModelsResponseDtoFromEntity(modelEntity: ModelEntity?): AllModelsResponseDto? = AllModelsResponseDto(
        modelEntity!!.modelName,
        markService.getMarkById(modelEntity.fkMarkId)
    )

    fun toEntityFromAddModelRequestDto(requestDto: AddModelRequestDto?): ModelEntity?
    {
        val modelEntity = ModelEntity()
        modelEntity.modelName = requestDto!!.modelName
        modelEntity.modelStatus = true
        modelEntity.fkMarkId = requestDto.fkMarkId

        return modelEntity
    }

    fun toModelResponseDtoFromEntity(entity: ModelEntity?): ModelResponseDto?
    = ModelResponseDto(
        entity!!.modelName,
        markService.findMarkById(entity.fkMarkId)
    )

}