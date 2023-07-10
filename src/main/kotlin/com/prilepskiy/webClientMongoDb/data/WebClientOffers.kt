package com.prilepskiy.webClientMongoDb.data
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux


@Component
//@EnableScheduling
class WebClientOffers {
    private val client = WebClient.create("http://192.168.0.121:8080/offers")

  //  @Scheduled(fixedRate = 1500)
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