package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Segments (

    @SerializedName("id"                ) var id                : String?           = null,
    @SerializedName("origin"            ) var origin            : io.flight.scrapping.providers.skyscrapper.DTO.Origin?           = io.flight.scrapping.providers.skyscrapper.DTO.Origin(),
    @SerializedName("destination"       ) var destination       : io.flight.scrapping.providers.skyscrapper.DTO.Destination?      = io.flight.scrapping.providers.skyscrapper.DTO.Destination(),
    @SerializedName("departure"         ) var departure         : String?           = null,
    @SerializedName("arrival"           ) var arrival           : String?           = null,
    @SerializedName("durationInMinutes" ) var durationInMinutes : Int?              = null,
    @SerializedName("flightNumber"      ) var flightNumber      : String?           = null,
    @SerializedName("marketingCarrier"  ) var marketingCarrier  : io.flight.scrapping.providers.skyscrapper.DTO.MarketingCarrier? = io.flight.scrapping.providers.skyscrapper.DTO.MarketingCarrier(),
    @SerializedName("operatingCarrier"  ) var operatingCarrier  : io.flight.scrapping.providers.skyscrapper.DTO.OperatingCarrier? = io.flight.scrapping.providers.skyscrapper.DTO.OperatingCarrier()

)