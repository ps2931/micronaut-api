package com.example.micronaut.controller

import com.example.micronaut.service.SpendThresholdService
import com.example.micronaut.service.ValidationService
import com.example.micronaut.utils.JsonParser
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import jakarta.inject.Inject

@Controller("/calibrate")
@Validated
class CalibrateIntakeController {

    @Inject
    lateinit var spendThresholdService: SpendThresholdService

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun getSpendThresholdRequest() = "Hello world"

    @Post("/submit/spendthreshold", produces = [MediaType.TEXT_PLAIN])
    fun saveSpendThreshold(@Body request: String): String {

        // Parse request to SpendThresholdRequest object.
        val spendThresholdRequestObject = JsonParser.parseSpendThresholdRequest(request)

        // Validate the SpendThresholdRequest object.
        val validationStatus = ValidationService.validateSpendThresholdRequest(spendThresholdRequestObject)

        if (validationStatus == "SUCCESS") { // Proceed if request received is VALIDATED successfully
            return spendThresholdService.saveSpendThresholdRequestIntake(spendThresholdRequestObject)
        } else { // otherwise save request but return error message
            spendThresholdService.saveSpendThresholdRequest(spendThresholdRequestObject)
            return "INCORRECT_REQUEST. PARSING FAILED. REASON: $validationStatus"
        }


//        // Check if record already exist for given client_uid.
//        val recordExists = spendThresholdPgRepository.existsById(spendThresholdRequestObject.clientUuid)


    }
}