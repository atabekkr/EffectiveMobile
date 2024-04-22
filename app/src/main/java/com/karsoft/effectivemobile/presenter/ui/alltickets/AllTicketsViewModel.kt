package com.karsoft.effectivemobile.presenter.ui.alltickets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Ticket
import com.karsoft.effectivemobile.domain.usecase.TicketUseCase
import com.karsoft.effectivemobile.presenter.models.OfferUI
import com.karsoft.effectivemobile.presenter.models.TicketUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTicketsViewModel @Inject constructor(private val useCase: TicketUseCase,
    private val mapper: Mapper<Ticket, TicketUI>): ViewModel() {

    private var _getAllTicketsResult = MutableSharedFlow<List<TicketUI>>()
    val getAllTicketsResult: Flow<List<TicketUI>> get() = _getAllTicketsResult
    fun getAllTickets() {
        viewModelScope.launch {
            val listOfOffers = useCase.getTickets().map {
                mapper.mapFromEntity(it)
            }
            _getAllTicketsResult.emit(listOfOffers)
        }
    }
}