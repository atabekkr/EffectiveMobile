package com.karsoft.effectivemobile.data.repository

import com.karsoft.effectivemobile.data.models.TicketResponse
import com.karsoft.effectivemobile.data.network.EffectiveService
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Ticket
import com.karsoft.effectivemobile.domain.repository.TicketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(private val mapper: Mapper<TicketResponse, Ticket>) :
    TicketRepository {

    private val api = EffectiveService
    override suspend fun getTickets(): List<Ticket> = withContext(Dispatchers.IO) {
        return@withContext api.getTickets().map {
            mapper.mapFromEntity(it)
        }
    }
}