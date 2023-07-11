package com.prilepskiy.webClientMongoDb.domain.service
import com.prilepskiy.webClientMongoDb.data.model.Merchant
import com.prilepskiy.webClientMongoDb.data.model.Offer
import com.prilepskiy.webClientMongoDb.domain.repository.OfferRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux


@Service
//@EnableScheduling
class OffersService(private val offerRepository: OfferRepository) {
    private val client = WebClient.create("http://192.168.0.121:8080/offers")

  //  @Scheduled(fixedRate = 1500)
  @PostConstruct
    private  fun initDate(){
        offerRepository.deleteAll()
        client.get()
            .retrieve()
            .bodyToFlux<Offer>()
            .toStream().forEach {
                offerRepository.save(it)
                println(it)
            }
    }

    fun findAllOffers():List<Offer> = offerRepository.findAll().toList()
}