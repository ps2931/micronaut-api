package com.example.micronaut.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.EmbeddedId
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.TypeDef
import io.micronaut.data.model.DataType
import java.sql.Timestamp
import javax.validation.constraints.NotBlank

/*
Entity to save validated SpendThresholdRequest
 */
@Introspected
@MappedEntity(value = "calibrate_spend_api_intake")
data class SpendThresholdIntakeEntity(

    @EmbeddedId val spendThresholdIntakeId: SpendThresholdIntakeId,

    @field:NotBlank
    var clientUuid: String,

    @field:NotBlank
    @field:TypeDef(type = DataType.JSON)
    var modelRequestPayload: String,

    @field:NotBlank
    var updatedAt: Timestamp,
)