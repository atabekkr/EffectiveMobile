package com.karsoft.effectivemobile.domain.repository

import com.karsoft.effectivemobile.domain.models.Ticket

interface TicketRepository {
    suspend fun getTickets(): List<Ticket>
}