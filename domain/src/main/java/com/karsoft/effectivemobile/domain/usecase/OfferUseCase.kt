package com.karsoft.effectivemobile.domain.usecase

import com.karsoft.effectivemobile.domain.models.Offer

interface OfferUseCase {
    suspend fun getOffers(): List<Offer>
}