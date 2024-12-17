package com.turboaz.mapper

import com.turboaz.dto.response.AccountDetailsResponseDto
import com.turboaz.dto.request.CreateAccountRequestDto
import com.turboaz.dto.response.AccountResponseDto
import com.turboaz.entity.AccountEntity
import org.springframework.stereotype.Component

@Component
class AccountConverter {

    fun toEntityFromCreateAccountRequestDto(requestDto: CreateAccountRequestDto?): AccountEntity?
    {
        val entity = AccountEntity()
        entity.accountName = requestDto!!.accountName
        entity.accountStatus = true
        entity.accountPhoneNumber = requestDto.accountPhoneNumber
        entity.accountLocation = "Account Location Not Defined"
        entity.accountDescription = "Account Description Not Defined"
        entity.accountProfilePhotoUrl = "Account Profile Photo Not Defined"
        entity.fkUserId = requestDto.fkUserId

        return entity
    }

    fun toAccountDetailsResponseDtoFromEntity(entity: AccountEntity?): AccountDetailsResponseDto? =
        AccountDetailsResponseDto(
            entity!!.accountName,
            entity.accountPhoneNumber,
            entity.accountLocation,
            entity.accountDescription,
            entity.accountProfilePhotoUrl
        )


    fun toAccountResponseDtoFromEntity(entity: AccountEntity?): AccountResponseDto?
    = AccountResponseDto(
        entity!!.accountName,
        entity.accountPhoneNumber,
        entity.accountLocation,
        entity.accountProfilePhotoUrl
    )

}