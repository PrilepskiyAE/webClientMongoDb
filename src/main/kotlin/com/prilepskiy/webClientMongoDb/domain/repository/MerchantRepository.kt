package com.prilepskiy.webClientMongoDb.domain.repository

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository


interface MerchantRepository: ReactiveCrudRepository<Merchant, Int>
