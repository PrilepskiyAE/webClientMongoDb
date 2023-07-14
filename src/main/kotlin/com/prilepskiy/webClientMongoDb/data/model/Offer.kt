package com.prilepskiy.webClientMongoDb.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Offer(
    @Id
    val id: String=  UUID.randomUUID().toString(),
    val offerId:Int,
    val name:String="",
    val price:String="",
    val merchants:List<Merchant> = listOf())
