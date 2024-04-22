package com.karsoft.effectivemobile.domain.models

data class Ticket(
    val id: Int,
    val arrival: Departure,
    val badge: String?,
    val company: String,
    val departure: Departure,
    val hand_luggage: HandLuggage,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val is_exchangable: Boolean,
    val is_returnable: Boolean,
    val luggage: Luggage,
    val price: Price,
    val provider_name: String
)