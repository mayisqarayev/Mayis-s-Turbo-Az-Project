package com.turboaz.repository

import com.turboaz.entity.ModelEntity
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface ModelRepository: JpaRepository<ModelEntity, String>
{
    @Transactional
    @Modifying
    @Query("update ModelEntity a set a.modelStatus = false where a.id = ?1")
    fun deleteModelById(id: String?)

    @Query("select a.modelName from ModelEntity a where a.fkMarkId = ?1")
    fun findModelNameByMarkId(markId: String?): Optional<String?>

}