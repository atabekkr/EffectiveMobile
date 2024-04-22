package com.karsoft.effectivemobile.data.network

import com.karsoft.effectivemobile.data.models.OfferResponse
import com.karsoft.effectivemobile.data.models.PriceResponse
import com.karsoft.effectivemobile.data.models.TicketOfferResponse

object EffectiveService {

    fun getOffers(): List<OfferResponse> {
        val listOfOffer = mutableListOf<OfferResponse>()
        listOfOffer.addAll(
            mutableListOf(
                OfferResponse(
                    id = 1,
                    title = "Die Antwoord",
                    town = "Будапешт",
                    price = PriceResponse(5000)
                ),
                OfferResponse(
                    id = 2,
                    title = "Socrat&Lera",
                    town = "Санкт-Петербург",
                    price = PriceResponse(1999)
                ),
                OfferResponse(
                    id = 3,
                    title = "Лампабикт",
                    town = "Москва",
                    price = PriceResponse(2390)
                ),
            )
        )
        return listOfOffer
    }

    fun getTicketsOffers(): MutableList<TicketOfferResponse> {
        val listOfTicketOffer = mutableListOf<TicketOfferResponse>()
        listOfTicketOffer.addAll(
            mutableListOf(
                TicketOfferResponse(
                    id = 1,
                    title = "Уральские авиалинии",
                    timeRange = listOf("07:00", "09:10", "10:00", "11:30", "14:15", "19:00", "21:00", "23:30"),
                    price = PriceResponse(3999)
                ),
                TicketOfferResponse(
                    id = 2,
                    title = "Победа",
                    timeRange = listOf("09:10", "21:00"),
                    price = PriceResponse(4999)
                ),
                TicketOfferResponse(
                    id = 3,
                    title = "NordStar",
                    timeRange = listOf("07:00"),
                    price = PriceResponse(2390)
                ),
            )
        )
        return listOfTicketOffer
    }

}