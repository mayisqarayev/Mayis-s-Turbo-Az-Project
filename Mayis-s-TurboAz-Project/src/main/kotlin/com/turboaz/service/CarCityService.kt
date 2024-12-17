package com.turboaz.service

import com.turboaz.repository.CarCityRepository
import org.springframework.stereotype.Service

@Service
class CarCityService(
    private val carCityRepository: CarCityRepository
) {

    fun getCarCityNameOfCarCityById(id: String?): String? = carCityRepository.findById(id!!).get().carCityName

}