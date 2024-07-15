package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Origin (

    @SerializedName("flightPlaceId" ) var flightPlaceId : String? = null,
    @SerializedName("displayCode"   ) var displayCode   : String? = null,
    @SerializedName("parent"        ) var parent        : io.flight.scrapping.providers.skyscrapper.DTO.Parent? = io.flight.scrapping.providers.skyscrapper.DTO.Parent(),
    @SerializedName("name"          ) var name          : String? = null,
    @SerializedName("type"          ) var type          : String? = null,
    @SerializedName("country"       ) var country       : String? = null

)