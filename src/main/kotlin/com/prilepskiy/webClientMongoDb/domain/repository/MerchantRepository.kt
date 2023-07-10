package com.prilepskiy.webClientMongoDb.domain.repository

import com.prilepskiy.webClientMongoDb.data.model.Merchant
import org.springframework.data.repository.CrudRepository

interface MerchantRepository : CrudRepository<Merchant, Int> {
}