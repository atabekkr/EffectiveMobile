package com.karsoft.effectivemobile.presenter.ui.home

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.karsoft.effectivemobile.R
import com.karsoft.effectivemobile.databinding.FragmentHomeBinding
import com.karsoft.effectivemobile.presenter.ui.home.adapter.OffersAdapter
import com.karsoft.effectivemobile.presenter.ui.home.viewmodel.OfferViewModel
import com.karsoft.effectivemobile.presenter.ui.home.viewmodel.TicketOfferViewModel
import com.karsoft.effectivemobile.utils.LocalStorage
import com.karsoft.effectivemobile.utils.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val placeOfferViewModel by viewModels<OfferViewModel>()
    private val ticketOfferViewModel by viewModels<TicketOfferViewModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = OffersAdapter()

    @Inject
    lateinit var localStorage: LocalStorage

    private var currentDay: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        setupViews(view)
        setupListeners()
        setupObservers()

    }

    private fun loadData() {
        placeOfferViewModel.getOffers()
    }

    private fun setupViews(view: View) {

        _binding = FragmentHomeBinding.bind(view)

        binding.rvOffers.adapter = adapter

        if (localStorage.lastInputCity.isNotBlank()) binding.etFromWhereFirstScreen.setText(
            localStorage.lastInputCity
        )

    }

    private fun setupListeners() {

        val bottomSheet = BottomSheet()

        binding.tvTipWhere.setOnClickListener {
            if (binding.etFromWhereFirstScreen.text.isNotBlank()) {
                localStorage.lastInputCity = binding.etFromWhereFirstScreen.text.toString()
                bottomSheet.show(childFragmentManager, bottomSheet.tag)
            } else {
                snackbar("Заполните поле Откуда летать")
            }
        }

        binding.ivExchange.setOnClickListener {
            val etWhereSecond = binding.etWhereSecondScreen.text
            binding.etWhereSecondScreen.setText(binding.etWhereFromSecondScreen.text)
            binding.etWhereFromSecondScreen.setText(etWhereSecond)
        }

        binding.ivClear.setOnClickListener {
            binding.etWhereSecondScreen.text.clear()
        }

        binding.btnShowAllTickets.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToAllTicketsFragment(binding.etWhereSecondScreen.text.toString())
            )
        }

        binding.btnBack.setOnClickListener {
            this.binding.llSecond.visibility = View.GONE
            this.binding.llFirst.visibility = View.VISIBLE
        }

        binding.llCalendarBack.setOnClickListener {
            openCalendar()
        }

        bottomSheet.setOnAnywhereItemClickListener { nameOfCity ->
            ticketOfferViewModel.getTicketOffers()
            changeUIState(nameOfCity)
        }

        bottomSheet.setOnTipClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToPlugFragment()
            )
        }

    }

    private fun changeUIState(nameOfCity: String) {

        binding.etWhereSecondScreen.setText(nameOfCity)
        binding.etWhereFromSecondScreen.setText(localStorage.lastInputCity)

        this.binding.llSecond.visibility = View.VISIBLE
        this.binding.llFirst.visibility = View.GONE

        val formatter = SimpleDateFormat("dd MMM EEE", Locale("ru"))
        val date = Date()
        currentDay = formatter.format(date)
        binding.tvCurrentDate.text = currentDay

    }

    private fun setupObservers() {

        placeOfferViewModel.getOffersResult.onEach {
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        ticketOfferViewModel.getTicketOffersResult.onEach { result ->

            binding.tvNameOfAviacompanyRed.text = result.getOrNull(0)?.title
            binding.tvPriceRed.text = result.getOrNull(0)?.price?.value.toString() + " ₽"
            binding.tvTimesRed.text = result.getOrNull(0)?.timeRange?.joinToString()

            binding.tvNameOfAviacompanyBlue.text = result.getOrNull(1)?.title
            binding.tvPriceBlue.text = result.getOrNull(1)?.price?.value.toString() + " ₽"
            binding.tvTimesBlue.text = result.getOrNull(1)?.timeRange?.joinToString()

            binding.tvNameOfAviacompanyWhite.text = result.getOrNull(2)?.title
            binding.tvPriceWhite.text = result.getOrNull(2)?.price?.value.toString() + " ₽"
            binding.tvTimesWhite.text = result.getOrNull(2)?.timeRange?.joinToString()


        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    private fun openCalendar() {
        val formatter = SimpleDateFormat("dd MMM EEE", Locale("ru"))
        val date = Date()
        currentDay = formatter.format(date)

        val dialog = DatePickerDialog(
            requireContext()
        )

        dialog.setOnDateSetListener { datePicker, year, month, day ->
            val selectDate = Date(year, month, day)
            val timeBack = formatter.format(selectDate)
            binding.tvTimeBack.text = timeBack
        }

        dialog.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}