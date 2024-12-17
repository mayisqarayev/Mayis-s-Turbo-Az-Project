package com.turboaz.service

import com.turboaz.dto.request.AddModelRequestDto
import com.turboaz.dto.response.AllModelsResponseDto
import com.turboaz.dto.response.ModelResponseDto
import com.turboaz.entity.ModelEntity
import com.turboaz.mapper.ModelConverter
import com.turboaz.repository.ModelRepository
import org.springframework.stereotype.Service

@Service
class ModelService(
    private val modelRepository: ModelRepository,
    private val modelConverter: ModelConverter
) {

    fun getAllModelsByMarkId(markId: String?): List<AllModelsResponseDto>? = modelRepository.findAll()
        .toMutableList()
        .stream()
        .map { modelConverter.toAllModelsResponseDtoFromEntity(it)!! }
        .toList()

    fun addNewModel(addModelRequestDto: AddModelRequestDto?) {
        modelRepository.save(modelConverter.toEntityFromAddModelRequestDto(addModelRequestDto)!!)
    }

    fun deleteModelById(id: String?) = modelRepository.deleteModelById(id)

    fun getModelById(id: String?): ModelResponseDto?
    {
        return modelConverter.toModelResponseDtoFromEntity(modelRepository.findById(id!!).get())
    }

    fun getModelNameByMarkId(markId: String?): String? = modelRepository.findModelNameByMarkId(markId).get()

    fun getModelEntityById(id: String?): ModelEntity? = modelRepository.findById(id!!).get()

}