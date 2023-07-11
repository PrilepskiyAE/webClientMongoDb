package com.prilepskiy.webClientMongoDb.domain.service

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import com.prilepskiy.webClientMongoDb.domain.repository.MerchantRepository
import jakarta.annotation.PostConstruct

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@Service
class MerchantService(private val merchantRepository: MerchantRepository) {
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
private  fun initDate(){
    merchantRepository.deleteAll()
    client.get()
        .retrieve()
        .bodyToFlux<Merchant>()
        .toStream().forEach {
                merchantRepository.save(it)
                println(it)
        }
}
    fun findAllMerchant():List<Merchant> = merchantRepository.findAll().toList()

}