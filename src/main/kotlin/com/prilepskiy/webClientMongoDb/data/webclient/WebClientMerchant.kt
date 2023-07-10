package com.prilepskiy.webClientMongoDb.data.webclient

import jakarta.annotation.PostConstruct

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@Component
class WebClientMerchant {
    private val client = WebClient.create("http://192.168.0.121:8080/merchants")

//    @PostConstruct
//    private  fun getDate(){
//
//        client.get()
//            .retrieve()
//            .bodyToFlux<String>()//тут будет MerchantOffer
//            .delayElements(Duration.ofMillis(1200))
//            .doOnNext {
//                println(it)
//            }.
//
//
//
//    }
@PostConstruct
private  fun getDate(){
    client.get()
        .retrieve()
        .bodyToFlux<String>()//тут будет MerchantOffer
        .toStream().forEach {
            println(it) //тут будет запись в бд
        }
}
}