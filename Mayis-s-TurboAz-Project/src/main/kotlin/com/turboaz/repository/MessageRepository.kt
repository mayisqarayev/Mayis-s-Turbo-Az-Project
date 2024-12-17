package com.turboaz.repository

import com.turboaz.entity.MessageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository: JpaRepository<MessageEntity, String>