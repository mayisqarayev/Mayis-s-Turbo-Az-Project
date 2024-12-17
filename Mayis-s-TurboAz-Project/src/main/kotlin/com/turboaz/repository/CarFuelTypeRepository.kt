package com.turboaz.repository

import com.turboaz.entity.CarFuelTypeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarFuelTypeRepository: JpaRepository<CarFuelTypeEntity, String>