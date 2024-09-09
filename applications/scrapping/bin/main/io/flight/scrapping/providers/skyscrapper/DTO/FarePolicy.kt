package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class FarePolicy (

  @SerializedName("isChangeAllowed"       ) var isChangeAllowed       : Boolean? = null,
  @SerializedName("isPartiallyChangeable" ) var isPartiallyChangeable : Boolean? = null,
  @SerializedName("isCancellationAllowed" ) var isCancellationAllowed : Boolean? = null,
  @SerializedName("isPartiallyRefundable" ) var isPartiallyRefundable : Boolean? = null

)