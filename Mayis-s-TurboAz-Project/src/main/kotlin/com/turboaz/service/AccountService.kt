package com.turboaz.service

import com.turboaz.dto.request.AccountDetailsRequestDto
import com.turboaz.dto.request.CreateAccountRequestDto
import com.turboaz.dto.response.AccountResponseDto
import com.turboaz.mapper.AccountConverter
import com.turboaz.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository, private val accountConverter: AccountConverter) {


    fun getAccountById(id: String?): AccountResponseDto? {
        return accountConverter.toAccountResponseDtoFromEntity(accountRepository.findById(id!!).get())
    }

    fun createAccount(requestDto: CreateAccountRequestDto) {
        accountRepository.save(accountConverter.toEntityFromCreateAccountRequestDto(requestDto)!!)
    }

    fun disableAccountById(id: String?) = accountRepository.disableAccountById(id)

    fun changeAccountDetailsById(requestDto: AccountDetailsRequestDto) {
        accountRepository.changeAccountDetailsById(
            requestDto.id,
            requestDto.accountName,
            requestDto.accountPhoneNumber,
            requestDto.accountDescription,
            requestDto.accountLocation,
            requestDto.accountProfilePhotoUrl
        )
    }

}