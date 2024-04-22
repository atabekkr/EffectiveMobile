package com.karsoft.effectivemobile.presenter.ui.plug

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.karsoft.effectivemobile.R
import com.karsoft.effectivemobile.databinding.FragmentPlugBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlugFragment : Fragment(R.layout.fragment_plug) {

    private var _binding: FragmentPlugBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlugBinding.bind(view)

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}