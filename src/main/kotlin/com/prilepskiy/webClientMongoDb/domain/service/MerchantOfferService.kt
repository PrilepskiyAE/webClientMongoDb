package com.prilepskiy.webClientMongoDb.domain.service

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import com.prilepskiy.webClientMongoDb.data.model.Offer
import com.prilepskiy.webClientMongoDb.data.model.OfferResponse
import com.prilepskiy.webClientMongoDb.domain.model.MerchantDTO
import com.prilepskiy.webClientMongoDb.domain.model.MerchantOfferDTO
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
        private val merchantService: MerchantService,
        private val offersService: OffersService) {
        private val client = WebClient.create("http://192.168.0.121:8090/offers")
    private val client2 = WebClient.create("http://192.168.0.121:8090/merchants")
   // private val merchant:List<Merchant> = merchantService.findAllMerchant()


   fun findAllMerchantOffers():Flux<Offer> = offersService.deleteAll().thenMany( Flux.zip(
       client.get()
       .retrieve()
       .bodyToFlux(OfferResponse::class.java).collectList(), client2.get()
           .retrieve()
           .bodyToFlux(Merchant::class.java).collectList())
            .flatMap { elements ->
                val result:MutableList<Offer> = mutableListOf()

                println(elements.t1)
                println(elements.t2)

                elements.t1.onEach {
                    resOffer ->
                    result.add(Offer(offerId = resOffer.id, name = resOffer.name, price = resOffer.price, merchants = elements.t2.filter {
                        it.id in resOffer.merchantId
                    }))
                }

              offersService.saveAll(result)



       }

       .thenMany(offersService.findAllOffers()))





//    fun findAllMerchantOffers():Flux<MerchantDTO>{
//       val merchantDTO: Flux<MerchantDTO> = merchantService.findAllMerchant().map {
//           MerchantDTO(it.id,it.name,it.category)
//       }
////       return offersService.findAllOffers().map {
////           val result :MutableSet<MerchantDTO> = mutableSetOf()
////           it.merchantId.forEach {merchantId ->
////               merchantDTO.forEach {merchant->
////                   if(merchantId==merchant.id)
////                       result.add(merchant)
////               }
////           }
////           MerchantOfferDTO(it.id,it.name,it.price,result.toList())
//       }
//    }
//fun findAllMerchantOffers():Flux<Offer> = offersService.deleteAll(). thenMany(
//    client.get()
//       .retrieve()
//       .bodyToMono(OfferResponse::class.java)
//
//
//        .flatMap {
//            println(it)
//            //val list=merchantService.getMerchant(it.merchantId).collectList().block()
//            offersService.save(Offer(offerId = it.id, name = it.name, price = it.price, merchants = list?: listOf()))
//        }
//
//.thenMany(offersService.findAllOffers()))


}