package io.flight.scrapping


import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ScrappingApplicationTests : io.flight.scrapping.common.CommonIntegrationTests() {

    @Autowired
    lateinit var flightsScrappingService: FlightsScrappingService;


    lateinit private var listener1: io.flight.scrapping.common.Listener1

    @Test
    fun shouldProcessNextFlight() {
        val searchResponseString = io.flight.scrapping.common.SkyScraperResponse().searchResponseString;

        // mock http request
        mockWebServer.enqueue(
            MockResponse()
                .setBody(searchResponseString)
                .addHeader("Content-Type", "application/json")
        )

        listener1 = harness.getSpy("RabbitListenerId")
        Assertions.assertNotNull(listener1)

        flightsScrappingService.processNext();

        val recordedRequest: RecordedRequest = mockWebServer.takeRequest()
        Assertions.assertEquals("GET", recordedRequest.method);

        var path = recordedRequest.path?.split('?')?.first()
        Assertions.assertEquals("/api/v2/flights/searchFlightsComplete", path);

        val expectedMessage = "{\"originSkyId\":\"LOND\",\"destinationSkyId\":\"NYCA\",\"price\":694.99}"


        verify(listener1).receive(expectedMessage)

        //TODO: Should have been added to the queue

    }

}
