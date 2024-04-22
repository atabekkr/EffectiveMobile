package com.karsoft.effectivemobile.domain.usecase.impl

import com.karsoft.effectivemobile.domain.models.Offer
import com.karsoft.effectivemobile.domain.repository.OfferRepository
import com.karsoft.effectivemobile.domain.usecase.OfferUseCase

class OfferUseCaseImpl(
    private val repository: OfferRepository,
) : OfferUseCase {
    override suspend fun getOffers(): List<Offer> {
        return repository.getOffers()
    }

}