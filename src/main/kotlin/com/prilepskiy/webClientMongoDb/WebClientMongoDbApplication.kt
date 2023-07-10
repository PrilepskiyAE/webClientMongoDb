package com.prilepskiy.webClientMongoDb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebClientMongoDbApplication

fun main(args: Array<String>) {
	runApplication<WebClientMongoDbApplication>(*args)
}
