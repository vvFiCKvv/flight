package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Duration (

  @SerializedName("min"          ) var min          : Int? = null,
  @SerializedName("max"          ) var max          : Int? = null,
  @SerializedName("multiCityMin" ) var multiCityMin : Int? = null,
  @SerializedName("multiCityMax" ) var multiCityMax : Int? = null

)