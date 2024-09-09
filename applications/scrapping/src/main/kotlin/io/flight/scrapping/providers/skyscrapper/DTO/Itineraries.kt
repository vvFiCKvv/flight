package io.flight.scrapping.providers.skyscrapper.DTO

import com.google.gson.annotations.SerializedName


data class Itineraries (

    @SerializedName("id"                      ) var id                      : String?         = null,
    @SerializedName("price"                   ) var price                   : io.flight.scrapping.providers.skyscrapper.DTO.Price?          = io.flight.scrapping.providers.skyscrapper.DTO.Price(),
    @SerializedName("legs"                    ) var legs                    : ArrayList<io.flight.scrapping.providers.skyscrapper.DTO.Legs> = arrayListOf(),
    @SerializedName("isSelfTransfer"          ) var isSelfTransfer          : Boolean?        = null,
    @SerializedName("isProtectedSelfTransfer" ) var isProtectedSelfTransfer : Boolean?        = null,
    @SerializedName("farePolicy"              ) var farePolicy              : io.flight.scrapping.providers.skyscrapper.DTO.FarePolicy?     = io.flight.scrapping.providers.skyscrapper.DTO.FarePolicy(),
    @SerializedName("eco"                     ) var eco                     : io.flight.scrapping.providers.skyscrapper.DTO.Eco?            = io.flight.scrapping.providers.skyscrapper.DTO.Eco(),
    @SerializedName("fareAttributes"          ) var fareAttributes          : io.flight.scrapping.providers.skyscrapper.DTO.FareAttributes? = io.flight.scrapping.providers.skyscrapper.DTO.FareAttributes(),
    @SerializedName("isMashUp"                ) var isMashUp                : Boolean?        = null,
    @SerializedName("hasFlexibleOptions"      ) var hasFlexibleOptions      : Boolean?        = null,
    @SerializedName("score"                   ) var score                   : Double?         = null

)