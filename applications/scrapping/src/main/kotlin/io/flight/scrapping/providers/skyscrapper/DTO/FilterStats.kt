package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class FilterStats (

    @SerializedName("duration"   ) var duration   : io.flight.scrapping.providers.skyscrapper.DTO.Duration?           = io.flight.scrapping.providers.skyscrapper.DTO.Duration(),
    @SerializedName("airports"   ) var airports   : ArrayList<io.flight.scrapping.providers.skyscrapper.DTO.Airports> = arrayListOf(),
    @SerializedName("carriers"   ) var carriers   : ArrayList<io.flight.scrapping.providers.skyscrapper.DTO.Carriers> = arrayListOf(),
    @SerializedName("stopPrices" ) var stopPrices : io.flight.scrapping.providers.skyscrapper.DTO.StopPrices?         = io.flight.scrapping.providers.skyscrapper.DTO.StopPrices()

)