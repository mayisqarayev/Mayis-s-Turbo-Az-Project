package com.turboaz.service

import com.turboaz.dto.request.AddMarkRequestDto
import com.turboaz.dto.response.AllMarksResponseDto
import com.turboaz.dto.response.MarkResponseDto
import com.turboaz.dto.response.MarkResponseDtoForModelResponseDto
import com.turboaz.mapper.MarkConverter
import com.turboaz.repository.MarkRepository
import org.springframework.stereotype.Service

@Service
class MarkService(
    private val markRepository: MarkRepository,
    private val markConverter: MarkConverter,
    private val modelService: ModelService
) {

    fun getAllMarks(): List<AllMarksResponseDto>? = markRepository.findAll()
            .toMutableList()
            .stream()
            .map { markConverter.toAllMarksResponseDtoFromEntity(it)!! }
            .toList()

    fun deleteMarkById(id: String?) = markRepository.deleteMarkById(id!!)


    fun addNewMark(requestDto: AddMarkRequestDto?) = markRepository.save(markConverter.toEntityFromAddMarkRequestDto(requestDto!!)!!)

    fun getMarkById(id: String?): MarkResponseDtoForModelResponseDto?
    = markConverter.toMarkResponseDtoForModelResponseDtoFromEntity(markRepository.findById(id!!).get())

    fun findMarkById(id: String?): MarkResponseDto?
    {
        return markConverter.toMarkResponseDtoFromEntity(markRepository.findById(id!!).get())
    }

    fun getMarkNameById(id: String?): String? {
        val markId = modelService.getModelEntityById(id!!)!!.fkMarkId

        return markRepository.findById(markId!!).get().markName
    }

}