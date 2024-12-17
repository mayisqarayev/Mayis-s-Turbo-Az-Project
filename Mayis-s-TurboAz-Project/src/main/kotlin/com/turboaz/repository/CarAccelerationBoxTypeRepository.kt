package com.turboaz.repository

import com.turboaz.entity.CarAccelerationBoxTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarAccelerationBoxTypeRepository: JpaRepository<CarAccelerationBoxTypeEntity, String>