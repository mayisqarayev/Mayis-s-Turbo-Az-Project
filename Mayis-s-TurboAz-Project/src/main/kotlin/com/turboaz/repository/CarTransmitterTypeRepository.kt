package com.turboaz.repository

import com.turboaz.entity.CarTransmitterTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarTransmitterTypeRepository: JpaRepository<CarTransmitterTypeEntity, String>