package com.karsoft.effectivemobile.data.mapper

import com.karsoft.effectivemobile.data.models.TicketOfferResponse
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Price
import com.karsoft.effectivemobile.domain.models.TicketOffer
import javax.inject.Inject

class TicketOfferMapper @Inject constructor(): Mapper<TicketOfferResponse, TicketOffer> {
    override fun mapFromEntity(from: TicketOfferResponse) = from.run {
        TicketOffer(
            id,
            title,
            timeRange,
            Price(price.value)
        )
    }
}