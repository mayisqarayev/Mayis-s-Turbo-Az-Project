package com.turboaz.service

import com.turboaz.repository.CarFuelTypeRepository
import org.springframework.stereotype.Service

@Service
class CarFuelTypeService(private val carFuelTypeRepository: CarFuelTypeRepository) {

    fun getCarFuelTypeNameById(id: String?): String? = carFuelTypeRepository.findById(id!!).get().carFuelTypeName

}