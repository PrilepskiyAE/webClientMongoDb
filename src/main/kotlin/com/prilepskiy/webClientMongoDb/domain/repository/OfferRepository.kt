package com.prilepskiy.webClientMongoDb.domain.repository

import com.prilepskiy.webClientMongoDb.data.model.Offer
import org.springframework.data.repository.CrudRepository

interface OfferRepository  : CrudRepository<Offer, Int>
