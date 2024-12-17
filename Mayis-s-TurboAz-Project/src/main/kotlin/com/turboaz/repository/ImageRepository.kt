package com.turboaz.repository

import com.turboaz.entity.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository: JpaRepository<ImageEntity, String>