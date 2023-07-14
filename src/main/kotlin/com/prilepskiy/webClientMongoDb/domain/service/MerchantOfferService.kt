package com.prilepskiy.webClientMongoDb.domain.service

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import com.prilepskiy.webClientMongoDb.data.model.Offer
import com.prilepskiy.webClientMongoDb.data.model.OfferResponse
import com.prilepskiy.webClientMongoDb.domain.model.MerchantDTO
import com.prilepskiy.webClientMongoDb.domain.model.MerchantOfferDTO
import com.prilepskiy.webClientMongoDb.domain.repository.OfferRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toMono
import java.time.Duration

@Service
class MerchantOfferService(
    private val offerRepository: OfferRepository
) {
    private val client = WebClient.create("http://192.168.0.121:8090/offers")
    private val client2 = WebClient.create("http://192.168.0.121:8090/merchants")

    fun findAllMerchantOffers(): Flux<Offer> = offerRepository.deleteAll().thenMany(Flux.zip(
        getResponseOffer(), getResponseMerchant()
    )
        .flatMap { elements ->
            val result: MutableList<Offer> = mutableListOf()
            elements.t1.onEach { resOffer ->
                result.add(
                    Offer(
                        offerId = resOffer.id,
                        name = resOffer.name,
                        price = resOffer.price,
                        merchants = elements.t2.filter {
                            it.id in resOffer.merchantId
                        })
                )
            }
            offerRepository.saveAll(result)
        }
        .thenMany(offerRepository.findAll()))


    private fun getResponseMerchant() = client2.get()
        .retrieve()
        .bodyToFlux(Merchant::class.java).collectList()

    private fun getResponseOffer() = client.get()
        .retrieve()
        .bodyToFlux(OfferResponse::class.java).collectList()
}