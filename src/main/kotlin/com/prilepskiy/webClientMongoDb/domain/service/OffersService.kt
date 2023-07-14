package com.prilepskiy.webClientMongoDb.domain.service

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import com.prilepskiy.webClientMongoDb.data.model.Offer
import com.prilepskiy.webClientMongoDb.data.model.OfferResponse
import com.prilepskiy.webClientMongoDb.domain.repository.OfferRepository

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
//@EnableScheduling
class OffersService(private val offerRepository: OfferRepository) {
    private val client = WebClient.create("http://192.168.0.121:8090/offers")

    //  @Scheduled(fixedRate = 1500)
    fun findAllOffers(): Flux<Offer> = offerRepository.findAll()
    fun deleteAll()
       = offerRepository.deleteAll()


    fun save(offer: Offer): Mono<Offer> = offerRepository.save(offer)
    fun saveAll(list: List<Offer>) = offerRepository.saveAll(list)

}