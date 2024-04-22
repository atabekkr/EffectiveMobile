package com.karsoft.effectivemobile.domain.models

data class Offer(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price,
)

data class Price(
    val value: Int,
)
