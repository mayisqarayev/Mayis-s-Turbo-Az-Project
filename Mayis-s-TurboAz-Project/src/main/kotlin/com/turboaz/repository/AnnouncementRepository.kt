package com.turboaz.repository

import com.turboaz.dto.request.UpdateAnnouncementRequestDto
import com.turboaz.entity.AnnouncementEntity
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface AnnouncementRepository: JpaRepository<AnnouncementEntity, String>
{
    @Query("select a from AnnouncementEntity a order by a.deploymentDate desc")
    fun findAnnouncementEntitiesSortByDeploymentDateDesc(): List<AnnouncementEntity>

    @Transactional
    @Modifying
    @Query("update AnnouncementEntity a set a.announcementStatus = false where a.id = ?1")
    fun deleteAnnouncementById(id: String?)

}