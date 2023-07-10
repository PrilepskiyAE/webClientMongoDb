package com.prilepskiy.webClientMongoDb.data.model

data class Offer(
    val id:Int,
    val name:String,
    val price:String,
    val merchantId:List<Int>)
