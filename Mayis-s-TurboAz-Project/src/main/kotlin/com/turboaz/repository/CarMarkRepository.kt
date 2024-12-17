package com.turboaz.repository

import com.turboaz.entity.CarMarkEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarMarkRepository: JpaRepository<CarMarkEntity, String>