package com.example.micronaut.model

import io.micronaut.data.annotation.Embeddable
import io.micronaut.data.annotation.MappedProperty
import java.sql.Timestamp

/*
Composite key for calibrate_spend_api_request table
 */
@Embeddable
data class SpendThresholdId(
    @MappedProperty(value = "client_uuid")
    val clientUuid: String,

    @MappedProperty(value = "created_at")
    val createdAt: Timestamp
)
