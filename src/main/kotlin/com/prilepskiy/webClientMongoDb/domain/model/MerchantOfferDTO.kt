package com.prilepskiy.webClientMongoDb.domain.model


data class MerchantOfferDTO(
    val id:Int,
    val name:String,
    val price:String,
    val merchants:List<MerchantDTO>)
