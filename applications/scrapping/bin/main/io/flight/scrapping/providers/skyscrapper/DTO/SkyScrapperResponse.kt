package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class SkyScrapperResponse(

    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: io.flight.scrapping.providers.skyscrapper.DTO.SkyScrapperData? = io.flight.scrapping.providers.skyscrapper.DTO.SkyScrapperData()

)