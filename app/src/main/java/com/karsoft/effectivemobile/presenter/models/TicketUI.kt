package com.karsoft.effectivemobile.presenter.models

data class TicketUI(
    val id: Int,
    val arrival: DepartureUI,
    val badge: String?,
    val company: String,
    val departure: DepartureUI,
    val hand_luggage: HandLuggageUI,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val is_exchangable: Boolean,
    val is_returnable: Boolean,
    val luggage: LuggageUI,
    val price: PriceUI,
    val provider_name: String
)