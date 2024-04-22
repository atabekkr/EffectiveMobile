package com.karsoft.effectivemobile.data.models

data class OfferResponse(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceResponse
)

data class PriceResponse(
    val value: Int
)
