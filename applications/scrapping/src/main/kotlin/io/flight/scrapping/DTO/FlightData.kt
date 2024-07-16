package io.flight.scrapping.DTO


data class FlightData(
    var originSkyId: String,
    var destinationSkyId: String,
    var price: Double
) {
}