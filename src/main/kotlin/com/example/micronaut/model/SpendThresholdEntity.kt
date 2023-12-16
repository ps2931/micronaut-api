package com.example.micronaut.model


import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.EmbeddedId
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.TypeDef
import io.micronaut.data.model.DataType
import java.sql.Timestamp
import javax.validation.constraints.NotBlank

/*
Entity to save raw SpendThresholdRequest
 */

@Introspected
@MappedEntity(value = "calibrate_spend_api_request")
data class SpendThresholdEntity(

    @EmbeddedId val spendThresholdId: SpendThresholdId,

    @field:NotBlank
    @field:TypeDef(type = DataType.JSON)
    var modelRequestPayload: String,

    @field:NotBlank
    var updatedAt: Timestamp,
)