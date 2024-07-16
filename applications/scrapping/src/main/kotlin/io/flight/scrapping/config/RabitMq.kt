package io.flight.scrapping.config

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@EnableRabbit
@Configuration
class RabitMq {

    @Value("\${spring.rabbitmq.username}")
    private val username: String? = null

    @Value("\${spring.rabbitmq.password}")
    private val password: String? = null

    @Value("\${spring.rabbitmq.vhost}")
    private val vHost: String? = null
}