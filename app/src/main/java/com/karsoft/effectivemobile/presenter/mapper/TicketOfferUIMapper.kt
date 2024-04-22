package com.karsoft.effectivemobile.presenter.mapper

import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.TicketOffer
import com.karsoft.effectivemobile.presenter.models.PriceUI
import com.karsoft.effectivemobile.presenter.models.TicketOfferUI
import javax.inject.Inject

class TicketOfferUIMapper @Inject constructor() : Mapper<TicketOffer, TicketOfferUI> {
    override fun mapFromEntity(from: TicketOffer) = from.run {
        TicketOfferUI(
            id,
            title,
            timeRange,
            PriceUI(price.value)
        )
    }
}