package com.prilepskiy.webClientMongoDb.domain.model

import com.prilepskiy.webClientMongoDb.data.model.Merchant


data class MerchantOfferDTO(
    val id: String?,
    val offerId:Int,
    val name:String,
    val price:String,
    val merchants:List<MerchantDTO> )
