package com.karsoft.effectivemobile.data.models

data class TicketOfferResponse(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: PriceResponse
)
