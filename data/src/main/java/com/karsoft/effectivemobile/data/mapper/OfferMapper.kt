package com.karsoft.effectivemobile.data.mapper

import com.karsoft.effectivemobile.data.models.OfferResponse
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Offer
import com.karsoft.effectivemobile.domain.models.Price
import javax.inject.Inject

class OfferMapper @Inject constructor() : Mapper<OfferResponse, Offer> {
    override fun mapFromEntity(from: OfferResponse) = from.run {
        Offer(
            id,
            title,
            town,
            Price(price.value)
        )
    }
}