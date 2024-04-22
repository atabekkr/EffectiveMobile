package com.karsoft.effectivemobile.presenter.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karsoft.effectivemobile.domain.mapper.base.Mapper
import com.karsoft.effectivemobile.domain.models.Offer
import com.karsoft.effectivemobile.domain.usecase.OfferUseCase
import com.karsoft.effectivemobile.presenter.models.OfferUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(
    private val useCase: OfferUseCase,
    private val mapper: Mapper<Offer, OfferUI>,
) : ViewModel() {

    private var _getOffersResult = MutableSharedFlow<List<OfferUI>>()
    val getOffersResult: Flow<List<OfferUI>> get() = _getOffersResult
    fun getOffers() {
        viewModelScope.launch {
            val listOfOffers = useCase.getOffers().map {
                mapper.mapFromEntity(it)
            }
            _getOffersResult.emit(listOfOffers)
        }
    }
}