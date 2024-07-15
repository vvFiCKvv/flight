package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Airports (

  @SerializedName("city"     ) var city     : String?             = null,
  @SerializedName("airports" ) var airports : ArrayList<io.flight.scrapping.providers.skyscrapper.DTO.Airports> = arrayListOf()

)