package com.turboaz.repository

import com.turboaz.entity.SelectEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SelectRepository: JpaRepository<SelectEntity, String>