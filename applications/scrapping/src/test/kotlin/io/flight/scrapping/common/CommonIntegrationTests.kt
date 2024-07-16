package io.flight.scrapping.common


import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.test.RabbitListenerTest
import org.springframework.amqp.rabbit.test.RabbitListenerTestHarness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.RabbitMQContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

public class Listener1 {
    @RabbitListener(id = "RabbitListenerId", queues = ["travel"])
    fun receive(message: String?) {
    }
}

@Configuration
@RabbitListenerTest
public class RabitMQConfig {
    @Bean
    public fun listener(): io.flight.scrapping.common.Listener1 {
        return io.flight.scrapping.common.Listener1();
    }
}


@Testcontainers
@AutoConfigureMockMvc
open class CommonIntegrationTests {

    companion object {

        @Container
        val rabbitMq: RabbitMQContainer = RabbitMQContainer("rabbitmq:3.12-management")
            .withExposedPorts(5672)


        lateinit var mockWebServer: MockWebServer;

        @DynamicPropertySource
        @JvmStatic
        fun registerProperties(registry: DynamicPropertyRegistry) {

            io.flight.scrapping.common.CommonIntegrationTests.Companion.setupHttpMock(registry)

            io.flight.scrapping.common.CommonIntegrationTests.Companion.setupRabitMq(registry)
        }

        private fun setupHttpMock(registry: DynamicPropertyRegistry) {
            io.flight.scrapping.common.CommonIntegrationTests.Companion.mockWebServer = MockWebServer()
            io.flight.scrapping.common.CommonIntegrationTests.Companion.mockWebServer.start();

            val skysprepperHost =
                "http://" + io.flight.scrapping.common.CommonIntegrationTests.Companion.mockWebServer.hostName + ":" + io.flight.scrapping.common.CommonIntegrationTests.Companion.mockWebServer.port
            registry.add("skysprepper.host", { -> skysprepperHost })
        }

        private fun setupRabitMq(registry: DynamicPropertyRegistry) {
            val vhost = "/";
            val exchange = "flight"
            val queue = "travel"
            val user = "user";
            val password = "password";
            registry.add(
                "spring.rabbitmq.host",
                io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq::getHost
            );
            registry.add(
                "spring.rabbitmq.port",
                io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq::getFirstMappedPort
            );
            registry.add("spring.rabbitmq.username", { -> user });
            registry.add("spring.rabbitmq.password", { -> password });
            registry.add("spring.rabbitmq.vhost", { -> vhost });




            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.start();
            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.execInContainer(
                "rabbitmqadmin",
                "declare",
                "vhost",
                "name=$vhost"
            )
            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.execInContainer(
                "rabbitmqadmin",
                "--vhost=$vhost",
                "declare",
                "exchange",
                "name=$exchange",
                "type=direct"
            )
            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.execInContainer(
                "rabbitmqadmin",
                "--vhost=$vhost",
                "declare",
                "queue",
                "name=$queue"
            );
            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.execInContainer(
                "rabbitmqadmin",
                "--vhost=$vhost",
                "declare",
                "binding",
                "source=$exchange",
                "destination=$queue"
            );

            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.execInContainer(
                "rabbitmqadmin", "declare", "user", "name=$user", "password=$password", "tags=administrator"
            );

            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.execInContainer(
                "rabbitmqadmin",
                "declare",
                "permission",
                "vhost=$vhost",
                "user=$user",
                "configure=.*",
                "write=.*",
                "read=.*"
            );
        }

        @BeforeAll
        @JvmStatic
        fun startDBContainer() {
        }

        @AfterAll
        @JvmStatic
        fun stopDBContainer() {
            io.flight.scrapping.common.CommonIntegrationTests.Companion.rabbitMq.stop()
            io.flight.scrapping.common.CommonIntegrationTests.Companion.mockWebServer.shutdown()
        }

    }


    @Autowired
    protected lateinit var objectMapper: ObjectMapper

    @Autowired
    protected lateinit var harness: RabbitListenerTestHarness


}
