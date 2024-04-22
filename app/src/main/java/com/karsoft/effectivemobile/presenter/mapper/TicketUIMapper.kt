package com.karsoft.effectivemobile.presenter.mapper

import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Ticket
import com.karsoft.effectivemobile.presenter.models.DepartureUI
import com.karsoft.effectivemobile.presenter.models.HandLuggageUI
import com.karsoft.effectivemobile.presenter.models.LuggageUI
import com.karsoft.effectivemobile.presenter.models.PriceUI
import com.karsoft.effectivemobile.presenter.models.TicketUI
import javax.inject.Inject

class TicketUIMapper @Inject constructor() : Mapper<Ticket, TicketUI> {
    override fun mapFromEntity(from: Ticket) = from.run {
        TicketUI(
            id,
            arrival = DepartureUI(
                airport = arrival.airport,
                date = arrival.date,
                town = arrival.town
            ),
            badge = badge,
            company,
            departure = DepartureUI(
                airport = departure.airport,
                date = departure.date,
                town = departure.town
            ),
            hand_luggage = HandLuggageUI(hand_luggage.has_hand_luggage, hand_luggage.size),
            has_transfer = has_transfer,
            has_visa_transfer = has_visa_transfer,
            is_exchangable = is_exchangable,
            is_returnable = is_returnable,
            luggage = LuggageUI(has_luggage = luggage.has_luggage, price = PriceUI(luggage.price.value)),
            price = PriceUI(price.value),
            provider_name = provider_name
        )
    }

}