package com.turboaz.repository

import com.turboaz.entity.ReportEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ReportRepository: JpaRepository<ReportEntity, String>