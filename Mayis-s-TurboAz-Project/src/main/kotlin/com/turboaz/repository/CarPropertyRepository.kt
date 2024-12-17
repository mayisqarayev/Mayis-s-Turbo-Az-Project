package com.turboaz.repository

import com.turboaz.entity.CarPropertyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarPropertyRepository: JpaRepository<CarPropertyEntity, String>