package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class MarketingCarrier (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("name"        ) var name        : String? = null,
  @SerializedName("alternateId" ) var alternateId : String? = null,
  @SerializedName("allianceId"  ) var allianceId  : Int?    = null,
  @SerializedName("displayCode" ) var displayCode : String? = null

)