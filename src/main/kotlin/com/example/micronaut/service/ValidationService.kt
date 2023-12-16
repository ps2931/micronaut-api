package com.example.micronaut.service

import com.example.micronaut.request.SpendThresholdRequest

class ValidationService {

    companion object {
        fun validateSpendThresholdRequest(stRequest: SpendThresholdRequest): String {

            if(stRequest.planType.uppercase() !in listOf("SPEND_THRESHOLD", "SEGMENTED", "HABIT_BUILDER"))
                return "INVALID PLAN TYPE."

            val modeledPlan = stRequest.modeledPlan

            if(modeledPlan.startDate > modeledPlan.endDate)
                return "START DATE CANNOT BE GREATER THAN END DATE."

            if(modeledPlan.markdownBudget <= 0)
                return "MARKDOWN BUDGET CANNOT BE 0."


            if(modeledPlan.roiGoal <= 0)
                return "ROI GOAL CANNOT BE 0."

            if (modeledPlan.optInGoalPercent <= 0)
                return "OPT IN GOAL PERCENT CANNOT BE 0."

            val difficultyLevels = setOf("HIGH", "MEDIUM", "LOW")
            if (modeledPlan.campaignDifficultyLevel.toSet() != difficultyLevels )
                return "MODEL'S DIFFICULTY LEVEL IS NOT CORRECT."

            if(modeledPlan.basketThresholdMin <= 0)
                return "BASKET THRESHOLD MIN CANNOT BE 0."

            if(modeledPlan.basketThresholdMax <= 0)
                return "BASKET THRESHOLD MAX CANNOT BE 0."

            val segmentation = setOf("SEGMENTED", "MASS")
            if(modeledPlan.segmentation !in segmentation)
                return "INCORRECT SEGMENTATION TYPE"

            val fulfillmentMethods = setOf("INSTORE", "SHIPPING", "SAME_DAY_DELIVERY", "ORDERPICKUP_DRIVEUP")
            if(modeledPlan.fulfillmentMethods.toSet() != fulfillmentMethods)
                return "INVALID FULFILLMENT METHOD"
            else
                return "SUCCESS"

        }
    }
}

