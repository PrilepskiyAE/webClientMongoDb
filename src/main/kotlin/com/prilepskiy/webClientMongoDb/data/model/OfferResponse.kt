package com.prilepskiy.webClientMongoDb.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OfferResponse (
                          val id:Int,
                          val name:String,
                          val price:String,
                          @JsonProperty("merchant_id")
                           val merchantId:List<Int> = listOf())
