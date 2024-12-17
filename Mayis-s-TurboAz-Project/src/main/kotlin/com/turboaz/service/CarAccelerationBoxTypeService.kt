package com.turboaz.service

import com.turboaz.repository.CarAccelerationBoxTypeRepository
import org.springframework.stereotype.Service

@Service
class CarAccelerationBoxTypeService(private val carAccelerationBoxTypeRepository: CarAccelerationBoxTypeRepository) {

    fun getCarAccelerationBoxTypeNameById(id: String?): String?
    = carAccelerationBoxTypeRepository.findById(id!!).get().carAccelerationBoxTypeName

}