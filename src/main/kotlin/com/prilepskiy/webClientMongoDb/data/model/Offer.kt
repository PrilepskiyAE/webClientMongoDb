package com.prilepskiy.webClientMongoDb.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Offer(
    @Id
    val id:Int,
    val name:String,
    val price:String,
    val merchantId:List<Int>)
