package com.prilepskiy.webClientMongoDb.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Merchant (
    @Id
    val id:Int,
    val name:String,
    val category:String
)