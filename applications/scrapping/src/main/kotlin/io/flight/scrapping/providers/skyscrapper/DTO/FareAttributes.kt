package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName

data class FareAttributes(@SerializedName("unknown") var unknown: Boolean? = null)