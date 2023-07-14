package com.prilepskiy.webClientMongoDb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories("com.prilepskiy.webClientMongoDb.domain.repository")
class WebClientMongoDbApplication

fun main(args: Array<String>) {
	runApplication<WebClientMongoDbApplication>(*args)
}
