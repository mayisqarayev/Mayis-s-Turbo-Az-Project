package com.turboaz.service

import com.turboaz.repository.CarColorRepository
import org.springframework.stereotype.Service

@Service
class CarColorService(
    private val carColorRepository: CarColorRepository
) {

    fun getCarColorNameById(id: String?): String? = carColorRepository.findById(id!!).get().carColorName

}