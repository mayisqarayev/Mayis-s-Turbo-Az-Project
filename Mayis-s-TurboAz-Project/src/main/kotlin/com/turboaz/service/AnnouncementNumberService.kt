package com.turboaz.service

import com.turboaz.entity.AnnouncementNumberEntity
import com.turboaz.repository.AnnouncementNumberRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.random.Random
import kotlin.streams.toList

@Service
class AnnouncementNumberService(private val numberRepository: AnnouncementNumberRepository) {

    private fun getAllAnnouncementNumbers(): List<AnnouncementNumberEntity> = numberRepository.findAll()

    fun generateAnnouncementNumber(length: Int = 8): String? {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        var announcementNumber: String?

        val allAnnouncementNumbers = getAllAnnouncementNumbers()
            .stream()
            .map { it.announcementNumber }
            .toList()

        do {
            announcementNumber = (1..length)
                .map { chars[Random.nextInt(chars.length)] }
                .joinToString("")
        } while (allAnnouncementNumbers.contains(announcementNumber))

        return announcementNumber
    }

}