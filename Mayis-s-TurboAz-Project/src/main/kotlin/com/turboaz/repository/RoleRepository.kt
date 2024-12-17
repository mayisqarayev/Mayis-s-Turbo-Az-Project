package com.turboaz.repository

import com.turboaz.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<RoleEntity, String>