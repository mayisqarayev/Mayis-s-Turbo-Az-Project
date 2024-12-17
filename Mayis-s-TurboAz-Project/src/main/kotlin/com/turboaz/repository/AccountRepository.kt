package com.turboaz.repository

import com.turboaz.entity.AccountEntity
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<AccountEntity, String>
{
    @Transactional
    @Modifying
    @Query("update AccountEntity a set a.accountStatus = false where a.id = ?1")
    fun disableAccountById(id: String?)

    @Transactional
    @Modifying
    @Query("""
        update AccountEntity a 
        set 
            a.accountName = ?2,
            a.accountPhoneNumber = ?3,
            a.accountLocation = ?4,
            a.accountDescription = ?5,
            a.accountProfilePhotoUrl = ?6
        where a.id = ?1
    """)
    fun changeAccountDetailsById(
        id: String?,
        accountName: String?,
        accountPhoneNumber: String?,
        accountLocation: String?,
        accountDescription: String?,
        accountProfilePhotoUrl: String?
    )
}