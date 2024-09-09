package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class StopPrices (

    @SerializedName("direct"    ) var direct    : io.flight.scrapping.providers.skyscrapper.DTO.Direct?    = io.flight.scrapping.providers.skyscrapper.DTO.Direct(),
    @SerializedName("one"       ) var one       : io.flight.scrapping.providers.skyscrapper.DTO.One?       = io.flight.scrapping.providers.skyscrapper.DTO.One(),
    @SerializedName("twoOrMore" ) var twoOrMore : io.flight.scrapping.providers.skyscrapper.DTO.TwoOrMore? = io.flight.scrapping.providers.skyscrapper.DTO.TwoOrMore()

)