package com.karsoft.effectivemobile.data.models

data class TicketResponse(
    val id: Int,
    val arrival: DepartureResponse,
    val badge: String?,
    val company: String,
    val departure: DepartureResponse,
    val hand_luggage: HandLuggageResponse,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val is_exchangable: Boolean,
    val is_returnable: Boolean,
    val luggage: LuggageResponse,
    val price: PriceResponse,
    val provider_name: String,
)