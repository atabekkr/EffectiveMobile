package com.karsoft.effectivemobile.presenter.ui.alltickets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.karsoft.effectivemobile.R
import com.karsoft.effectivemobile.databinding.FragmentAllTicketsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTicketsFragment: Fragment(R.layout.fragment_all_tickets) {

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)
        setupListeners()

    }

    private fun setupViews(view:View) {

        _binding = FragmentAllTicketsBinding.bind(view)

    }

    private fun setupListeners() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}