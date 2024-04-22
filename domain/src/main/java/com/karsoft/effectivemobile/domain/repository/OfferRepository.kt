package com.karsoft.effectivemobile.domain.repository

import com.karsoft.effectivemobile.domain.models.Offer

interface OfferRepository {
    suspend fun getOffers(): List<Offer>
}