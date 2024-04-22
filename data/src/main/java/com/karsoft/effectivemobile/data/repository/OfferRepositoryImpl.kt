package com.karsoft.effectivemobile.data.repository

import com.karsoft.effectivemobile.data.models.OfferResponse
import com.karsoft.effectivemobile.data.network.EffectiveService
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Offer
import com.karsoft.effectivemobile.domain.repository.OfferRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(
    private val mapper: Mapper<OfferResponse, Offer>,
) : OfferRepository {

    private val api = EffectiveService
    override suspend fun getOffers(): List<Offer> = withContext(Dispatchers.IO) {
        return@withContext api.getOffers().map {
            mapper.mapFromEntity(it)
        }
    }
}