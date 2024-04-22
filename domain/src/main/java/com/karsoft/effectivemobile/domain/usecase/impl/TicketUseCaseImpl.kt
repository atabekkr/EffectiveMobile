package com.karsoft.effectivemobile.domain.usecase.impl

import com.karsoft.effectivemobile.domain.repository.TicketRepository
import com.karsoft.effectivemobile.domain.usecase.TicketUseCase

class TicketUseCaseImpl(private val repository: TicketRepository): TicketUseCase {
    override suspend fun getTickets() = repository.getTickets()
}