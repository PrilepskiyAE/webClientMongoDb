package com.prilepskiy.webClientMongoDb.domain.repository

import com.prilepskiy.webClientMongoDb.data.model.Offer

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono



interface OfferRepository  : ReactiveCrudRepository<Offer, String>

