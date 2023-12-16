package com.example.micronaut.service

import com.example.micronaut.model.SpendThresholdEntity
import com.example.micronaut.model.SpendThresholdId
import com.example.micronaut.model.SpendThresholdIntakeEntity
import com.example.micronaut.model.SpendThresholdIntakeId
import com.example.micronaut.repository.SpendThresholdIntakeRepository
import com.example.micronaut.repository.SpendThresholdRepository
import com.example.micronaut.request.SpendThresholdRequest
import com.google.gson.Gson
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.sql.Timestamp
import java.util.*

@Singleton
class SpendThresholdService {

    @Inject
    private lateinit var spendThresholdRepository: SpendThresholdRepository

    @Inject
    private lateinit var spendThresholdIntakeRepository: SpendThresholdIntakeRepository

    fun saveSpendThresholdRequest(stRequest: SpendThresholdRequest): String {
        try {

            // Create SpendThreshold object.
            val createdAT = Timestamp(System.currentTimeMillis())
            val updatedAT = Timestamp(System.currentTimeMillis())
            val spendThresholdId = SpendThresholdId(stRequest.clientUuid, createdAT)
            val spendThresholdEntity = SpendThresholdEntity(
                spendThresholdId,
                Gson().toJson(stRequest),
                updatedAT
            )

            // Insert spendThresholdEntity into table1
            val stEntity = spendThresholdRepository.save(spendThresholdEntity)
            return "SUCCESS"
        } catch (ex: Exception) {
            println("Error inserting spend threshold request: ${ex.localizedMessage}")
            return "FAILURE"
        }
    }


    fun saveSpendThresholdRequestIntake(stRequest: SpendThresholdRequest): String {

        try {
            // Create SpendThreshold object.
            val createdAT = Timestamp(System.currentTimeMillis())
            val updatedAT = Timestamp(System.currentTimeMillis())
            val spendThresholdId = SpendThresholdId(stRequest.clientUuid, createdAT)
            val spendThresholdEntity = SpendThresholdEntity(
                spendThresholdId,
                Gson().toJson(stRequest),
                updatedAT
            )

            // Insert spendThresholdEntity into table1
            val stEntity = spendThresholdRepository.save(spendThresholdEntity)

            // Create SpendThresholdIntake object
            val calibrateUUID = UUID.randomUUID().toString()
            val spendThresholdIntakeId = SpendThresholdIntakeId(calibrateUUID, createdAT)
            val spendThresholdIntakeEntity = SpendThresholdIntakeEntity(
                spendThresholdIntakeId,
                stRequest.clientUuid,
                Gson().toJson(stRequest),
                updatedAT
            )

            // Insert spendThresholdIntakeEntity into table2
            val stIntakeEntity = spendThresholdIntakeRepository.save(spendThresholdIntakeEntity)

            return calibrateUUID

        }catch(ex: Exception) {
            val message = ex.localizedMessage
            println(message)
            return "FAILURE"
        }
    }
}