package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Price (

  @SerializedName("raw"             ) var raw             : Double? = null,
  @SerializedName("formatted"       ) var formatted       : String? = null,
  @SerializedName("pricingOptionId" ) var pricingOptionId : String? = null

)