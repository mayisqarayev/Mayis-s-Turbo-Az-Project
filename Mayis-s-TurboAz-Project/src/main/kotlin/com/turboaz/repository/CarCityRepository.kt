package com.turboaz.repository

import com.turboaz.entity.CarCityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarCityRepository: JpaRepository<CarCityEntity, String>