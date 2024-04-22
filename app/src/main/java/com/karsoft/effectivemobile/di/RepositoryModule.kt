package com.karsoft.effectivemobile.di

import com.karsoft.effectivemobile.data.repository.OfferRepositoryImpl
import com.karsoft.effectivemobile.data.repository.TicketOfferRepositoryImpl
import com.karsoft.effectivemobile.data.repository.TicketRepositoryImpl
import com.karsoft.effectivemobile.domain.repository.OfferRepository
import com.karsoft.effectivemobile.domain.repository.TicketOfferRepository
import com.karsoft.effectivemobile.domain.repository.TicketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindOfferRepository(
        repository: OfferRepositoryImpl,
    ): OfferRepository

    @Binds
    fun bindTicketOfferRepository(
        repository: TicketOfferRepositoryImpl,
    ): TicketOfferRepository

    @Binds
    fun bindTicketRepository(
        repository: TicketRepositoryImpl,
    ): TicketRepository
}