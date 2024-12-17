package com.turboaz.mapper

import com.turboaz.dto.request.AddNewCarPropertyRequestDto
import com.turboaz.dto.response.CarPropertyResponseDto
import com.turboaz.entity.CarPropertyEntity
import com.turboaz.service.CarPropertyService
import com.turboaz.service.MarkService
import com.turboaz.service.ModelService
import org.springframework.stereotype.Component

@Component
class CarPropertyConverter(
    private val propertyService: CarPropertyService,
    private val markService: MarkService,
    private val modelService: ModelService
) {

    fun toEntityFromAddNewCarPropertyRequestDto(requestDto: AddNewCarPropertyRequestDto?): CarPropertyEntity?
    {
        val entity = CarPropertyEntity()
        entity.fkCarCityId = requestDto!!.fkCarCityId
        entity.fkCarMarkId = requestDto.fkCarMarkId
        entity.fkCarModelId = requestDto.fkCarModelId
        entity.carDepartureDate = requestDto.carDepartureDate
        entity.fkCarBanTypeId = requestDto.fkCarBanTypeId
        entity.fkCarColorId = requestDto.fkCarColorId
        entity.carEngine = requestDto.carEngine
        entity.fkCarFuelTypeId = requestDto.fkCarFuelTypeId
        entity.carMarch = requestDto.carMarch
        entity.fkCarAccelerationBoxTypeId = requestDto.fkCarAccelerationBoxTypeId
        entity.fkCarTransmitterTypeId = requestDto.fkCarTransmitterTypeId
        entity.carIsNew = requestDto.carIsNew
        entity.carPropertyStatus = true

        return entity
    }

    fun toCarPropertyResponseDtoFromEntity(entity: CarPropertyEntity?): CarPropertyResponseDto?
    {
        return CarPropertyResponseDto(
            propertyService.getCarCityNameOfPropertyById(entity!!.fkCarCityId),
            markService.findMarkById(entity.fkCarMarkId)!!.markName,
            modelService.getModelNameByMarkId(entity.fkCarModelId)!!,
            entity.carDepartureDate,
            propertyService.getCarBanTypeNameOfPropertyById(entity.fkCarBanTypeId),
            propertyService.getCarColorNameOfPropertyById(entity.fkCarColorId),
            entity.carEngine,
            propertyService.getCarFuelTypeNameOfPropertyById(entity.fkCarFuelTypeId),
            entity.carMarch,
            propertyService.getCarAccelerationBoxTypeNameOfPropertyById(entity.fkCarAccelerationBoxTypeId),
            propertyService.getCarTransmitterTypeNameOfPropertyById(entity.fkCarTransmitterTypeId),
            entity.carIsNew
        )
    }

}