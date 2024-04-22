package com.karsoft.effectivemobile.domain.usecase.impl

import com.karsoft.effectivemobile.domain.repository.TicketOfferRepository
import com.karsoft.effectivemobile.domain.usecase.TicketOfferUseCase

class TicketOfferUseCaseImpl(private val repository: TicketOfferRepository) :
    TicketOfferUseCase {
    override suspend fun getTicketOffers() = repository.getTicketOffers()
}