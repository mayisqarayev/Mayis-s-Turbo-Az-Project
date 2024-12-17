package com.turboaz.repository

import com.turboaz.entity.AnnouncementNumberEntity
import org.hibernate.annotations.Struct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnnouncementNumberRepository: JpaRepository<AnnouncementNumberEntity, String>