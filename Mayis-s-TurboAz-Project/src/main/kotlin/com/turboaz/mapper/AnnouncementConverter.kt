package com.turboaz.mapper

import com.turboaz.dto.request.AddNewAnnouncementRequestDto
import com.turboaz.dto.request.AddNewCarPropertyRequestDto
import com.turboaz.dto.response.*
import com.turboaz.entity.AnnouncementEntity
import com.turboaz.service.*
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate

@Component
class AnnouncementConverter(
    private val accountService: AccountService,
    private val carPropertyService: CarPropertyService,
    private val modelService: ModelService,
    private val markService: MarkService,
    private val announcementService: AnnouncementService,
    private val numberService: AnnouncementNumberService
) {

    fun toEntityFromAddNewAnnouncementRequestDto(requestDto: AddNewAnnouncementRequestDto?): AnnouncementEntity? {
        val entity = AnnouncementEntity()
        entity.announcementName = markService.getMarkNameById(requestDto!!.fkMarkId)+
                modelService.getModelById(requestDto.fkModelId)!!.modelName + ", " +
                requestDto.carEngine + " L, " +
                requestDto.carDepartureDate!!.year + " il, " +
                requestDto.carMarch + " km"
        entity.announcementPrice = requestDto.announcementPrice
        entity.announcementIsSelected = false
        entity.announcementDescription = requestDto.announcementDescription
        entity.announcementNumber = numberService.generateAnnouncementNumber()
        entity.deploymentDate = LocalDate.now()
        entity.countOfView = BigDecimal.ZERO
        entity.announcementStatus = true
        entity.fkModelId = requestDto.fkModelId

        val carProperty = carPropertyService.addNewCarProperty(
            AddNewCarPropertyRequestDto(
                requestDto.fkCarCityId,
                requestDto.fkMarkId,
                requestDto.fkModelId,
                requestDto.carDepartureDate,
                requestDto.fkCarBanTypeId,
                requestDto.fkCarColorId,
                requestDto.carEngine,
                requestDto.fkCarFuelTypeId,
                requestDto.carMarch,
                requestDto.fkCarAccelerationBoxTypeId,
                requestDto.fkCarTransmitterTypeId,
                requestDto.carIsNew
            )
        )

        entity.fkCarPropertyId = carProperty!!.id
        entity.fkAccountId = requestDto.fkAccountId

        return entity
    }

    fun toAllAnnouncementsResponseDtoFromEntity(entity: AnnouncementEntity?): AllAnnouncementsResponseDto?
    = AllAnnouncementsResponseDto(
        entity!!.announcementName,
        entity.announcementPrice,
        entity.announcementStatus,
        entity.deploymentDate,
    )

    fun toAnnouncementResponseDtoFromEntity(entity: AnnouncementEntity?): AnnouncementResponseDto?
    {
        return AnnouncementResponseDto(
            entity!!.announcementName,
            entity.announcementPrice,
            entity.announcementIsSelected,
            entity.announcementDescription,
            entity.announcementNumber,
            entity.deploymentDate,
            entity.countOfView,
            accountService.getAccountById(entity.fkAccountId),
            carPropertyService.getCarPropertyById(entity.fkCarPropertyId),
            modelService.getModelById(entity.fkModelId)
        )
    }

}