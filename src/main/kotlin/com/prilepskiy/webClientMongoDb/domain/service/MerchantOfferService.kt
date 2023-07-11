package com.prilepskiy.webClientMongoDb.domain.service

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import com.prilepskiy.webClientMongoDb.data.model.Offer
import com.prilepskiy.webClientMongoDb.domain.model.MerchantDTO
import com.prilepskiy.webClientMongoDb.domain.model.MerchantOfferDTO
import org.springframework.stereotype.Service

@Service
class MerchantOfferService(
        private val merchantService: MerchantService,
        private val offersService: OffersService) {
   // private val merchant:List<Merchant> = merchantService.findAllMerchant()
   // private val offer:List<Offer> = offersService.findAllOffers()
    fun findAllMerchantOffers():List<MerchantOfferDTO>{
       val merchantDTO:List<MerchantDTO> = merchantService.findAllMerchant().map {
           MerchantDTO(it.id,it.name,it.category)
       }
       return offersService.findAllOffers().map {
           val result :MutableSet<MerchantDTO> = mutableSetOf()
           it.merchantId.forEach {merchantId ->
               merchantDTO.forEach {merchant->
                   if(merchantId==merchant.id)
                       result.add(merchant)
               }
           }
           MerchantOfferDTO(it.id,it.name,it.price,result.toList())
       }
    }
}