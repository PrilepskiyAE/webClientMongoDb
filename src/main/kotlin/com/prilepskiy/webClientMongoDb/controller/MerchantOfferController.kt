package com.prilepskiy.webClientMongoDb.controller

import com.prilepskiy.webClientMongoDb.domain.model.MerchantDTO
import com.prilepskiy.webClientMongoDb.domain.model.MerchantOfferDTO
import com.prilepskiy.webClientMongoDb.domain.service.MerchantOfferService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/merchantOffer")
class MerchantOfferController(private val merchantOfferService: MerchantOfferService) {
    @GetMapping
    fun getMerchantOffer(): Flux<MerchantOfferDTO> = merchantOfferService.findAllMerchantOffers().map { offer ->
        MerchantOfferDTO(offer.id, offer.offerId,offer.name,offer.price,offer.merchants.map {
            MerchantDTO(it.id,it.name,it.category)
        })
    }


}