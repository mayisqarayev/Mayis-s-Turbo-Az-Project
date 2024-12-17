package com.turboaz.repository

import com.sun.source.doctree.SeeTree
import com.turboaz.entity.MarkEntity
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface MarkRepository: JpaRepository<MarkEntity, String> {

    @Transactional
    @Modifying
    @Query("update MarkEntity a set a.markStatus = false where a.id = ?1")
    fun deleteMarkById(id: String)

}