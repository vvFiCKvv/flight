package io.flight.scrapping

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScrappingApplication

fun main(args: Array<String>) {
	runApplication<ScrappingApplication>(*args)
}
