package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Legs (

    @SerializedName("id"                ) var id                : String?             = null,
    @SerializedName("origin"            ) var origin            : io.flight.scrapping.providers.skyscrapper.DTO.Origin?             = io.flight.scrapping.providers.skyscrapper.DTO.Origin(),
    @SerializedName("destination"       ) var destination       : io.flight.scrapping.providers.skyscrapper.DTO.Destination?        = io.flight.scrapping.providers.skyscrapper.DTO.Destination(),
    @SerializedName("durationInMinutes" ) var durationInMinutes : Int?                = null,
    @SerializedName("stopCount"         ) var stopCount         : Int?                = null,
    @SerializedName("isSmallestStops"   ) var isSmallestStops   : Boolean?            = null,
    @SerializedName("departure"         ) var departure         : String?             = null,
    @SerializedName("arrival"           ) var arrival           : String?             = null,
    @SerializedName("timeDeltaInDays"   ) var timeDeltaInDays   : Int?                = null,
    @SerializedName("carriers"          ) var carriers          : io.flight.scrapping.providers.skyscrapper.DTO.Carriers?           = io.flight.scrapping.providers.skyscrapper.DTO.Carriers(),
    @SerializedName("segments"          ) var segments          : ArrayList<io.flight.scrapping.providers.skyscrapper.DTO.Segments> = arrayListOf()

)