package com.turboaz.service

import com.turboaz.repository.CarBanTypeRepository
import org.springframework.stereotype.Service

@Service
class CarBanTypeService(
    private val carBanTypeRepository: CarBanTypeRepository
) {

    fun getCarBanTypeNameById(id: String?): String? = carBanTypeRepository.findById(id!!).get().carBanTypeName

}