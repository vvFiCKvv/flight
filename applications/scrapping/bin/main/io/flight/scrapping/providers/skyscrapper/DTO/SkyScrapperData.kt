package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class SkyScrapperData(

    @SerializedName("context") var context: io.flight.scrapping.providers.skyscrapper.DTO.Context? = io.flight.scrapping.providers.skyscrapper.DTO.Context(),
    @SerializedName("itineraries") var itineraries: ArrayList<io.flight.scrapping.providers.skyscrapper.DTO.Itineraries> = arrayListOf(),
    @SerializedName("messages") var messages: ArrayList<String> = arrayListOf(),
    @SerializedName("filterStats") var filterStats: io.flight.scrapping.providers.skyscrapper.DTO.FilterStats? = io.flight.scrapping.providers.skyscrapper.DTO.FilterStats(),
    @SerializedName("flightsSessionId") var flightsSessionId: String? = null,
    @SerializedName("destinationImageUrl") var destinationImageUrl: String? = null

)