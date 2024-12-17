package com.turboaz.repository

import com.turboaz.entity.CarBanTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarBanTypeRepository: JpaRepository<CarBanTypeEntity, String>