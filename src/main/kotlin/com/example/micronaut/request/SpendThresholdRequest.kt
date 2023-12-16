package com.example.micronaut.request

import com.google.gson.annotations.SerializedName
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nonnull

@Serdeable
@Introspected
data class SpendThresholdRequest (

    @SerializedName("plan_type"          ) @Nonnull var planType          : String ,
    @SerializedName("client_uuid"        ) @Nonnull var clientUuid        : String ,
    @SerializedName("plan_name"          ) @Nonnull var planName          : String ,
    @SerializedName("business_objective" ) @Nonnull var businessObjective : String?     = null ,
    @SerializedName("modeled_plan"       ) @Nonnull var modeledPlan       : ModeledPlan

)

data class Inclusion (

    @SerializedName("id"              ) @Nonnull var id             : String? = null,
    @SerializedName("name"            ) @Nonnull var name           : String? = null,
    @SerializedName("type"            ) @Nonnull var type           : String? = null,
    @SerializedName("markdown_budget" ) @Nonnull var markdownBudget : Int?    = null

)

data class Exclusion (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("type" ) var type : String? = null

)

data class Audiences (

    @SerializedName("inclusion" ) var inclusion : ArrayList<Inclusion> = arrayListOf(),
    @SerializedName("exclusion" ) var exclusion : ArrayList<Exclusion> = arrayListOf()

)

data class Communications (

    @SerializedName("type"      ) var type     : String? = null,
    @SerializedName("channel"   ) var channel  : String? = null,
    @SerializedName("send_date" ) var sendDate : String? = null

)

data class ModeledPlan (

    @SerializedName("type"                      ) var type                    : String,
    @SerializedName("start_date"                ) var startDate               : String,
    @SerializedName("end_date"                  ) var endDate                 : String,
    @SerializedName("markdown_budget"           ) var markdownBudget          : Int,
    @SerializedName("roi_goal"                  ) var roiGoal                 : Int,
    @SerializedName("opt_in_goal_percent"       ) var optInGoalPercent        : Int,
    @SerializedName("campaign_difficulty_level" ) var campaignDifficultyLevel : ArrayList<String>         = arrayListOf(),
    @SerializedName("basket_threshold_min"      ) var basketThresholdMin      : Int,
    @SerializedName("basket_threshold_max"      ) var basketThresholdMax      : Int,
    @SerializedName("segmentation"              ) var segmentation            : String,
    @SerializedName("fulfillment_methods"       ) var fulfillmentMethods      : ArrayList<String>         = arrayListOf(),
    @SerializedName("pos_messaging_enabled"     ) var posMessagingEnabled     : Boolean?                  = null,
    @SerializedName("audiences"                 ) var audiences               : Audiences?                = Audiences(),
    @SerializedName("communications"            ) var communications          : ArrayList<Communications> = arrayListOf()

)