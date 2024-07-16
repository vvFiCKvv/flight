package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Context (

  @SerializedName("status"       ) var status       : String? = null,
  @SerializedName("sessionId"    ) var sessionId    : String? = null,
  @SerializedName("totalResults" ) var totalResults : Int?    = null

)