package com.karsoft.effectivemobile.di

import com.karsoft.effectivemobile.domain.repository.OfferRepository
import com.karsoft.effectivemobile.domain.repository.TicketOfferRepository
import com.karsoft.effectivemobile.domain.repository.TicketRepository
import com.karsoft.effectivemobile.domain.usecase.OfferUseCase
import com.karsoft.effectivemobile.domain.usecase.TicketOfferUseCase
import com.karsoft.effectivemobile.domain.usecase.TicketUseCase
import com.karsoft.effectivemobile.domain.usecase.impl.OfferUseCaseImpl
import com.karsoft.effectivemobile.domain.usecase.impl.TicketOfferUseCaseImpl
import com.karsoft.effectivemobile.domain.usecase.impl.TicketUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun bindOfferUseCase(
        repo: OfferRepository,
    ): OfferUseCase {
        return OfferUseCaseImpl(repo)
    }

    @Provides
    @Singleton
    fun bindTicketOfferUseCase(
        repo: TicketOfferRepository,
    ): TicketOfferUseCase {
        return TicketOfferUseCaseImpl(repo)
    }

    @Provides
    @Singleton
    fun bindTicketUseCase(
        repo: TicketRepository,
    ): TicketUseCase {
        return TicketUseCaseImpl(repo)
    }
}