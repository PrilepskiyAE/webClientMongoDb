package com.prilepskiy.webClientMongoDb.controller

import com.prilepskiy.webClientMongoDb.domain.service.MerchantOfferService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchantOffer")
class MerchantOfferController(private val merchantOfferService: MerchantOfferService) {
    @GetMapping
    fun getMerchantOffer()=merchantOfferService.findAllMerchantOffers()


}