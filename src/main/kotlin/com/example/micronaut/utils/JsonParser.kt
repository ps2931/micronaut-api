package com.example.micronaut.utils

import com.example.micronaut.request.SpendThresholdRequest
import com.example.micronaut.validation.NullableTypAdapterFactory
import com.google.gson.GsonBuilder

class JsonParser {
    companion object {
        fun parseSpendThresholdRequest(spendThreshold: String): SpendThresholdRequest {
            val gson = GsonBuilder()
                .registerTypeAdapterFactory(NullableTypAdapterFactory())
                .create()

            return gson.fromJson(spendThreshold, SpendThresholdRequest::class.java)
        }
    }

}