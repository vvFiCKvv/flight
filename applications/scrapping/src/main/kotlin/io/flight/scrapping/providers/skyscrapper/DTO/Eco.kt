package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Eco (

  @SerializedName("ecoContenderDelta" ) var ecoContenderDelta : Double? = null

)