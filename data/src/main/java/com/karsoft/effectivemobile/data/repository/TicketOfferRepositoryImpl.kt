package com.karsoft.effectivemobile.data.repository

import com.karsoft.effectivemobile.data.models.TicketOfferResponse
import com.karsoft.effectivemobile.data.network.EffectiveService
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.TicketOffer
import com.karsoft.effectivemobile.domain.repository.TicketOfferRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TicketOfferRepositoryImpl @Inject constructor(private val mapper: Mapper<TicketOfferResponse, TicketOffer>) :
    TicketOfferRepository {

    private val api = EffectiveService
    override suspend fun getTicketOffers(): List<TicketOffer> = withContext(Dispatchers.IO) {
        return@withContext api.getTicketsOffers().map {
            mapper.mapFromEntity(it)
        }
    }
}