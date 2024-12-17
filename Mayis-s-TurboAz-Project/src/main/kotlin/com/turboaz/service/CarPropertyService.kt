package com.turboaz.service

import com.turboaz.dto.request.AddNewCarPropertyRequestDto
import com.turboaz.dto.response.CarPropertyResponseDto
import com.turboaz.entity.CarPropertyEntity
import com.turboaz.mapper.CarPropertyConverter
import com.turboaz.repository.CarPropertyRepository
import org.springframework.stereotype.Service

@Service
class CarPropertyService(
    private val carPropertyRepository: CarPropertyRepository,
    private val carPropertyConverter: CarPropertyConverter,
    private val carCityService: CarCityService,
    private val carBanTypeService: CarBanTypeService,
    private val carColorService: CarColorService,
    private val carFuelTypeService: CarFuelTypeService,
    private val carAccelerationBoxTypeService: CarAccelerationBoxTypeService,
    private val carTransmitterTypeService: CarTransmitterTypeService
) {

    fun addNewCarProperty(requestDto: AddNewCarPropertyRequestDto): CarPropertyEntity?
    {
        return carPropertyRepository.save(carPropertyConverter.toEntityFromAddNewCarPropertyRequestDto(requestDto)!!)
    }

    fun updateCarPropertyById(id: String?)
    {

    }

    fun getCarPropertyById(id: String?): CarPropertyResponseDto?
    {
        return carPropertyConverter.toCarPropertyResponseDtoFromEntity(carPropertyRepository.findById(id!!).get())
    }

    fun getCarCityNameOfPropertyById(id: String?): String? = carCityService.getCarCityNameOfCarCityById(
        carPropertyRepository.findById(id!!).get().fkCarCityId
    )

    fun getCarBanTypeNameOfPropertyById(id: String?): String? = carBanTypeService.getCarBanTypeNameById(
        carPropertyRepository.findById(id!!).get().fkCarBanTypeId
    )

    fun getCarColorNameOfPropertyById(id: String?): String? = carColorService.getCarColorNameById(
        carPropertyRepository.findById(id!!).get().fkCarColorId
    )

    fun getCarEngineOfPropertyById(id: String?): String? = carPropertyRepository.findById(id!!).get().carEngine

    fun getCarFuelTypeNameOfPropertyById(id: String?): String? = carFuelTypeService.getCarFuelTypeNameById(
        carPropertyRepository.findById(id!!).get().fkCarFuelTypeId
    )

    fun getCarMarchOfPropertyById(id: String?): String? = carPropertyRepository.findById(id!!).get().carMarch

    fun getCarAccelerationBoxTypeNameOfPropertyById(id: String?): String? = carAccelerationBoxTypeService.getCarAccelerationBoxTypeNameById(
        carPropertyRepository.findById(id!!).get().fkCarAccelerationBoxTypeId
    )

    fun getCarTransmitterTypeNameOfPropertyById(id: String?): String? = carTransmitterTypeService.getCarTransmitterTypeNameById(
        carPropertyRepository.findById(id!!).get().fkCarTransmitterTypeId
    )

    fun getCarIsNewOfPropertyById(id: String?): Boolean? = carPropertyRepository.findById(id!!).get().carIsNew
}