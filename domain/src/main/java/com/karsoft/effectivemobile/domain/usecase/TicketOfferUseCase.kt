package com.karsoft.effectivemobile.domain.usecase

import com.karsoft.effectivemobile.domain.models.TicketOffer

interface TicketOfferUseCase {

    suspend fun getTicketOffers() : List<TicketOffer>
}