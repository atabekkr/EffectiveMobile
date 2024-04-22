package com.karsoft.effectivemobile.domain.usecase

import com.karsoft.effectivemobile.domain.models.Ticket

interface TicketUseCase {

    suspend fun getTickets(): List<Ticket>
}