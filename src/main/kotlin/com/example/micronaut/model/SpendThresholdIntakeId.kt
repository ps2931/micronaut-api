package com.example.micronaut.model

import io.micronaut.data.annotation.Embeddable
import io.micronaut.data.annotation.MappedProperty
import java.sql.Timestamp

/*
Composite key for calibrate_spend_api_intake table
 */

@Embeddable
data class SpendThresholdIntakeId(
    @MappedProperty(value = "calibrate_uuid")
    val calibrateUuid: String,

    @MappedProperty(value = "created_at")
    val createdAT: Timestamp
)
