package com.karsoft.effectivemobile.domain.repository

import com.karsoft.effectivemobile.domain.models.TicketOffer

interface TicketOfferRepository {
    suspend fun getTicketOffers(): List<TicketOffer>
}