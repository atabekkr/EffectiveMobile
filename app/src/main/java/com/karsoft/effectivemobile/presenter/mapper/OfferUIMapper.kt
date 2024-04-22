package com.karsoft.effectivemobile.presenter.mapper

import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Offer
import com.karsoft.effectivemobile.presenter.models.OfferUI
import com.karsoft.effectivemobile.presenter.models.PriceUI
import javax.inject.Inject

class OfferUIMapper @Inject constructor() : Mapper<Offer, OfferUI> {
    override fun mapFromEntity(from: Offer) = from.run {
        OfferUI(
            id,
            title,
            town,
            PriceUI(price.value)
        )
    }
}