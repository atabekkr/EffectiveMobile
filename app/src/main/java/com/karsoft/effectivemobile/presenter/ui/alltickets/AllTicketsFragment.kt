package com.karsoft.effectivemobile.presenter.ui.alltickets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.karsoft.effectivemobile.R
import com.karsoft.effectivemobile.databinding.FragmentAllTicketsBinding
import com.karsoft.effectivemobile.utils.LocalStorage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class AllTicketsFragment : Fragment(R.layout.fragment_all_tickets) {

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<AllTicketsViewModel>()

    private val navArgs by navArgs<AllTicketsFragmentArgs>()

    private val adapter = AllTicketsAdapter()

    @Inject
    lateinit var localStorage: LocalStorage

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        setupViews(view)
        setupListeners()
        setupObservers()

    }

    private fun loadData() {
        viewModel.getAllTickets()
    }

    private fun setupViews(view: View) {

        _binding = FragmentAllTicketsBinding.bind(view)

        binding.rvTickets.adapter = adapter

        val formatter = SimpleDateFormat("dd MMMM", Locale("ru"))
        val date = Date()
        val currentDay = formatter.format(date)
        binding.tvCurrentDate.text = currentDay + ", 1 пассажир"

        binding.tvTowns.text = "${localStorage.lastInputCity}-${navArgs.arrivalTown}"

    }

    private fun setupListeners() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupObservers() {
        viewModel.getAllTicketsResult.onEach { result ->
            adapter.submitList(result)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}