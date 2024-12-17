package com.turboaz.service

import com.turboaz.dto.request.AddNewAnnouncementRequestDto
import com.turboaz.dto.response.AllAnnouncementsPageResponseDto
import com.turboaz.dto.request.AllAnnouncementsRequestDto
import com.turboaz.dto.response.AllAnnouncementsResponseDto
import com.turboaz.dto.request.AnnouncementFilerRequestDto
import com.turboaz.dto.request.UpdateAnnouncementRequestDto
import com.turboaz.dto.response.AnnouncementResponseDto
import com.turboaz.entity.AnnouncementEntity
import com.turboaz.mapper.AnnouncementConverter
import com.turboaz.repository.AnnouncementRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.random.Random

@Service
class AnnouncementService(
    private val announcementRepository: AnnouncementRepository,
    private val announcementConverter: AnnouncementConverter,
    private val markService: MarkService,
    private val modelService: ModelService,
    private val propertyService: CarPropertyService
) {

    fun deleteAnnouncementById(id: String?)
    {
        announcementRepository.deleteAnnouncementById(id!!)
    }

    fun updateAnnouncementById(requestDto: UpdateAnnouncementRequestDto)


    fun addNewAnnouncement(requestDto: AddNewAnnouncementRequestDto?)
    {
        announcementRepository.save(announcementConverter.toEntityFromAddNewAnnouncementRequestDto(requestDto)!!)
    }

    fun getAnnouncementById(id: String?): AnnouncementResponseDto?
    {
        return announcementConverter.toAnnouncementResponseDtoFromEntity(announcementRepository.findById(id!!).get())
    }

    fun getAllAnnouncementsByFilter(requestDto: AnnouncementFilerRequestDto?): List<AllAnnouncementsResponseDto?>? {
        val allAnnouncements = announcementRepository.findAll()

        helpForFilter(requestDto, allAnnouncements)

        return allAnnouncements.toMutableList().stream()
            .map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it) }
            .toList()
    }

    fun getAllAnnouncementsSortByDeploymentDateDesc(accountId: String?): List<AllAnnouncementsResponseDto>? {
        return announcementRepository.findAnnouncementEntitiesSortByDeploymentDateDesc().toMutableList().stream()
            .map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it!!)!! }.toList()
    }

    fun getAllAnnouncementsByAccountId(accountId: String?): List<AllAnnouncementsResponseDto>? {
        return announcementRepository.findAll().toMutableList().stream()
            .map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it!!)!! }.toList()
    }

    fun getAllAnnouncementsByAccountIdPagination(
        requestDto: AllAnnouncementsRequestDto?
    ): AllAnnouncementsPageResponseDto? {

        val announcementPage = announcementRepository.findAll(
            PageRequest.of(requestDto!!.pageNumber!!, requestDto.pageSize!!)
        )

        val allAnnouncementsDto = announcementPage.content.toMutableList().stream()
            .filter { it.fkAccountId == requestDto.accountId }
            .map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it) }.toList()

        return AllAnnouncementsPageResponseDto(
            announcementPage.totalElements,
            announcementPage.totalPages.toLong(),
            announcementPage.isEmpty,
            allAnnouncementsDto
        )
    }

    fun getAllAnnouncementsByAccountIdSortByPrice(accountId: String?): List<AllAnnouncementsResponseDto>? {
        val findAll = announcementRepository.findAll().apply {
            sortWith(Comparator.comparingLong { it.announcementPrice!!.toLong() })
        }

        return findAll.toMutableList().stream()
            .map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it!!)!! }.toList()
    }

    fun getAllAnnouncementsByAccountIdSortByPricePagination(
        requestDto: AllAnnouncementsRequestDto?
    ): AllAnnouncementsPageResponseDto? {
        val announcementPage =
            announcementRepository.findAll(PageRequest.of(requestDto?.pageNumber!!, requestDto.pageSize!!))

        val content = announcementPage.content.apply {
            sortWith(Comparator.comparingLong { it.announcementPrice!!.toLong() })
        }.stream().map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it!!)!! }.toList()

        return AllAnnouncementsPageResponseDto(
            announcementPage.totalElements, announcementPage.totalPages.toLong(), announcementPage.isEmpty, content
        )
    }

    fun getAllAnnouncementsByAccountIdSortByPriceDesc(accountId: String?): List<AllAnnouncementsResponseDto>? {
        val findAll = announcementRepository.findAll().apply {
            sortWith(Comparator.comparingLong<AnnouncementEntity?> { it.announcementPrice!!.toLong() }.reversed())
        }

        return findAll.toMutableList().stream()
            .map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it!!)!! }.toList()
    }

    fun getAllAnnouncementsByAccountIdSortByPriceDescPagination(
        requestDto: AllAnnouncementsRequestDto?
    ): AllAnnouncementsPageResponseDto? {
        val announcementPage =
            announcementRepository.findAll(PageRequest.of(requestDto?.pageNumber!!, requestDto.pageSize!!))

        val content = announcementPage.content.apply {
            sortWith(Comparator.comparingLong<AnnouncementEntity?> { it.announcementPrice!!.toLong() }.reversed())
        }.stream().map { announcementConverter.toAllAnnouncementsResponseDtoFromEntity(it!!)!! }.toList()

        return AllAnnouncementsPageResponseDto(
            announcementPage.totalElements, announcementPage.totalPages.toLong(), announcementPage.isEmpty, content
        )
    }

    private fun helpForFilter(requestDto: AnnouncementFilerRequestDto?, entities: List<AnnouncementEntity>?): List<AnnouncementEntity> {
        if (requestDto!!.carCity != null) entities!!.toMutableList().stream()
            .filter { propertyService.getCarCityNameOfPropertyById(it.fkCarPropertyId) == requestDto.carCity }
            .toList()

        if (requestDto.carMark != null) entities!!.toMutableList().stream().filter {
            markService.getMarkNameById(modelService.getModelEntityById(it.fkModelId)!!.fkMarkId) == requestDto.carMark
        }.toList()

        if (requestDto.carModel != null) entities!!.toMutableList().stream().filter {
            modelService.getModelNameByMarkId(it.fkModelId) == requestDto.carModel
        }.toList()

        if (requestDto.carBanType != null) entities!!.toMutableList().stream().filter {
            propertyService.getCarBanTypeNameOfPropertyById(it.fkCarPropertyId) == requestDto.carBanType
        }.toList()

        if (requestDto.carColor != null) entities!!.toMutableList().stream().filter {
            propertyService.getCarColorNameOfPropertyById(it.fkCarPropertyId) == requestDto.carColor
        }.toList()

        if (requestDto.carEngine != null) entities!!.toMutableList().stream()
            .filter { propertyService.getCarEngineOfPropertyById(it.fkCarPropertyId) == requestDto.carEngine }
            .toList()

        if (requestDto.carFuelType != null) entities!!.toMutableList().stream().filter {
            propertyService.getCarFuelTypeNameOfPropertyById(it.fkCarPropertyId) == requestDto.carFuelType
        }.toList()

        if (requestDto.carMarch != null) entities!!.toMutableList().stream()
            .filter { propertyService.getCarMarchOfPropertyById(it.fkCarPropertyId) == requestDto.carMarch }
            .toList()

        if (requestDto.carAccelerationBoxType != null) entities!!.toMutableList().stream().filter {
            propertyService
                .getCarAccelerationBoxTypeNameOfPropertyById(it.fkCarPropertyId) == requestDto.carAccelerationBoxType
        }.toList()

        if (requestDto.carTransmitterType != null) entities!!.toMutableList().stream().filter {
            propertyService.getCarTransmitterTypeNameOfPropertyById(it.fkCarPropertyId) == requestDto.carTransmitterType
        }.toList()

        if (requestDto.carIsNew != null) entities!!.toMutableList().stream()
            .filter { propertyService.getCarIsNewOfPropertyById(it.fkCarPropertyId) == requestDto.carIsNew }
            .toList()

        entities!!.sortedByDescending { it.deploymentDate }

        return entities
    }
}