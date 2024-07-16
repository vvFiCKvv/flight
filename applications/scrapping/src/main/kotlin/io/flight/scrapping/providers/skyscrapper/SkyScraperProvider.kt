package io.flight.scrapping.providers.skyscrapper

import io.flight.scrapping.providers.skyscrapper.DTO.SkyScrapperData
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.reactive.function.client.WebClient

@Service
data class SkyScraperProvider(
    var originSkyId: String = "LOND",
    var destinationSkyId: String = "NYCA",
    var originEntityId: String = "27544008",
    var destinationEntityId: String = "27537542",
    var date: String = "2024-07-18",
    var cabinClass: String = "economy",
    var adults: Int = 1,
    var env: Environment,
    var webClient: WebClient,
) {


    fun search(): SkyScrapperData {
        val host: String = env.getProperty("skysprepper.host").toString()
        val apiKey: String = env.getProperty("skysprepper.apiKey").toString()

        var url = "${host}/api/v2/flights/searchFlightsComplete?originSkyId=${
            originSkyId
        }&destinationSkyId=${
            destinationSkyId
        }&originEntityId=${
            originEntityId
        }&destinationEntityId=${
            destinationEntityId
        }&date=${
            date
        }&cabinClass=${cabinClass}&adults=${adults}&sortBy=best&limit=10&currency=USD&market=en-US&countryCode=US"

        val res: io.flight.scrapping.providers.skyscrapper.DTO.SkyScrapperResponse? = webClient.get()
            .uri(url)
            .headers { httpHeaders ->
                {
                    httpHeaders.set("x-rapidapi-host", "sky-scrapper.p.rapidapi.com");
                    httpHeaders.set("x-rapidapi-key", apiKey);
                }
            }
            .retrieve()
            .bodyToMono(io.flight.scrapping.providers.skyscrapper.DTO.SkyScrapperResponse::class.java)
            .block()
        if (res != null && res.status == true && res.message == "success") {
            return res.data!!;
        }
        throw HttpClientErrorException(HttpStatus.CONFLICT, res?.message.toString());
    }
}