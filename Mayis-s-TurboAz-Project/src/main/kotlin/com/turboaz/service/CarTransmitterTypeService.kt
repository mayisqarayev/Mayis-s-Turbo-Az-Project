package com.turboaz.service

import com.turboaz.repository.CarTransmitterTypeRepository
import org.springframework.stereotype.Service

@Service
class CarTransmitterTypeService(private val carTransmitterTypeRepository: CarTransmitterTypeRepository) {

    fun getCarTransmitterTypeNameById(id: String?): String? = carTransmitterTypeRepository.findById(id!!).get().carTransmitterTypeName

}