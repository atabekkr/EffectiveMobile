package com.karsoft.effectivemobile.di

import com.karsoft.effectivemobile.data.mapper.OfferMapper
import com.karsoft.effectivemobile.data.mapper.TicketMapper
import com.karsoft.effectivemobile.data.mapper.TicketOfferMapper
import com.karsoft.effectivemobile.data.models.OfferResponse
import com.karsoft.effectivemobile.data.models.TicketOfferResponse
import com.karsoft.effectivemobile.data.models.TicketResponse
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Offer
import com.karsoft.effectivemobile.domain.models.Ticket
import com.karsoft.effectivemobile.domain.models.TicketOffer
import com.karsoft.effectivemobile.presenter.mapper.OfferUIMapper
import com.karsoft.effectivemobile.presenter.mapper.TicketOfferUIMapper
import com.karsoft.effectivemobile.presenter.mapper.TicketUIMapper
import com.karsoft.effectivemobile.presenter.models.OfferUI
import com.karsoft.effectivemobile.presenter.models.TicketOfferUI
import com.karsoft.effectivemobile.presenter.models.TicketUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindOfferMapper(
        mapper: OfferMapper,
    ): Mapper<OfferResponse, Offer>

    @Binds
    abstract fun bindOfferUIMapper(
        mapper: OfferUIMapper,
    ): Mapper<Offer, OfferUI>

    @Binds
    abstract fun bindTicketOfferMapper(
        mapper: TicketOfferMapper,
    ): Mapper<TicketOfferResponse, TicketOffer>

    @Binds
    abstract fun bindTicketOfferUIMapper(
        mapper: TicketOfferUIMapper,
    ): Mapper<TicketOffer, TicketOfferUI>

    @Binds
    abstract fun bindTicketMapper(
        mapper: TicketMapper,
    ): Mapper<TicketResponse, Ticket>

    @Binds
    abstract fun bindTicketUIMapper(
        mapper: TicketUIMapper,
    ): Mapper<Ticket, TicketUI>
}