package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class One (

  @SerializedName("isPresent"      ) var isPresent      : Boolean? = null,
  @SerializedName("formattedPrice" ) var formattedPrice : String?  = null

)