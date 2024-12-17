package com.turboaz.repository

import com.turboaz.entity.CarColorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarColorRepository: JpaRepository<CarColorEntity, String>