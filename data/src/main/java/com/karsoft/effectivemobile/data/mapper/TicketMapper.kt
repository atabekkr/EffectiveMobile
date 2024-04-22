package com.karsoft.effectivemobile.data.mapper

import com.karsoft.effectivemobile.data.models.TicketResponse
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Departure
import com.karsoft.effectivemobile.domain.models.HandLuggage
import com.karsoft.effectivemobile.domain.models.Luggage
import com.karsoft.effectivemobile.domain.models.Price
import com.karsoft.effectivemobile.domain.models.Ticket
import javax.inject.Inject

class TicketMapper @Inject constructor() : Mapper<TicketResponse, Ticket> {
    override fun mapFromEntity(from: TicketResponse) = from.run {
        Ticket(
            id = id,
            arrival = Departure(
                airport = arrival.airport,
                date = arrival.date,
                town = arrival.town
            ),
            badge = badge,
            company = company,
            departure = Departure(
                airport = departure.airport,
                date = departure.date,
                town = departure.town
            ),
            hand_luggage = HandLuggage(hand_luggage.has_hand_luggage, hand_luggage.size),
            has_transfer = has_transfer,
            has_visa_transfer = has_visa_transfer,
            is_exchangable = is_exchangable,
            is_returnable = is_returnable,
            luggage = Luggage(has_luggage = luggage.has_luggage, price = Price(luggage.price.value)),
            price = Price(price.value),
            provider_name = provider_name
        )
    }

}