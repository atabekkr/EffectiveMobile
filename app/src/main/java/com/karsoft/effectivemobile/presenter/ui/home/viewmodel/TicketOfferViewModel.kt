package com.karsoft.effectivemobile.presenter.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.TicketOffer
import com.karsoft.effectivemobile.domain.usecase.TicketOfferUseCase
import com.karsoft.effectivemobile.presenter.models.TicketOfferUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TicketOfferViewModel @Inject constructor(
    private val useCase: TicketOfferUseCase,
    private val mapper: Mapper<TicketOffer, TicketOfferUI>,
) : ViewModel() {

    private var _getTicketOffersResult = MutableSharedFlow<List<TicketOfferUI>>()
    val getTicketOffersResult: Flow<List<TicketOfferUI>> get() = _getTicketOffersResult
    fun getTicketOffers() {
        viewModelScope.launch {
            val listOfOffers = useCase.getTicketOffers().map {
                mapper.mapFromEntity(it)
            }
            _getTicketOffersResult.emit(listOfOffers)
        }
    }
}