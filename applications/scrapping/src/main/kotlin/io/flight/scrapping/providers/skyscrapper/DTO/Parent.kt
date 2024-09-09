package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Parent (

  @SerializedName("flightPlaceId" ) var flightPlaceId : String? = null,
  @SerializedName("displayCode"   ) var displayCode   : String? = null,
  @SerializedName("name"          ) var name          : String? = null,
  @SerializedName("type"          ) var type          : String? = null

)