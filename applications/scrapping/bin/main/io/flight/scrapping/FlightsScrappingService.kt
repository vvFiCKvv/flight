package io.flight.scrapping

import com.fasterxml.jackson.databind.ObjectMapper
import io.flight.scrapping.DTO.FlightData
import io.flight.scrapping.providers.skyscrapper.SkyScraperProvider
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FlightsScrappingService() {
    @Autowired
    private lateinit var provider: SkyScraperProvider;

    @Autowired
    private lateinit var rabbitTemplate: RabbitTemplate

    @Autowired
    private lateinit var mapper: ObjectMapper;

    fun getNextFlight(): FlightData? {
        val localProvider = provider.copy(date = "")
        val flights = localProvider.search();

        val prices = flights.itineraries;
        val bestPrice = prices.stream()
            .filter { pr -> pr.price!!.raw != null }
            .findFirst()
            .map { pr -> pr.price!!.raw }

        if (bestPrice == null || bestPrice.isEmpty) {
            return null;
        }
        return FlightData(
            originSkyId = provider.originSkyId,
            destinationSkyId = provider.destinationSkyId,
            price = bestPrice.get()
        )
    }

    fun send(data: FlightData) {

        rabbitTemplate.convertAndSend("travel", mapper.writeValueAsString(data))
    }

    fun processNext() {
        val flight = getNextFlight();
        if (flight != null) {
            send(flight)
        }
    }

}