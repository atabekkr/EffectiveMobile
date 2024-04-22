package com.karsoft.effectivemobile.presenter.models

data class TicketOfferUI(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: PriceUI,
)
