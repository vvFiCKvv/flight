package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Marketing (

  @SerializedName("id"      ) var id      : Int?    = null,
  @SerializedName("logoUrl" ) var logoUrl : String? = null,
  @SerializedName("name"    ) var name    : String? = null

)