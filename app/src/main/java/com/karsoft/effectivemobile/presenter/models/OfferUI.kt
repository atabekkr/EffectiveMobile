package com.karsoft.effectivemobile.presenter.models

data class OfferUI(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceUI
)

data class PriceUI(
    val value: Int
)
