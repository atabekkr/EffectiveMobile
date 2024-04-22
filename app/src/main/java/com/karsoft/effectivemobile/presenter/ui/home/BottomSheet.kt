package com.karsoft.effectivemobile.presenter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.karsoft.effectivemobile.R
import com.karsoft.effectivemobile.databinding.BottomSheetSearchTicketBinding
import com.karsoft.effectivemobile.utils.LocalStorage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetSearchTicketBinding

    @Inject
    lateinit var localStorage: LocalStorage

    private fun getWindowHeight() = resources.displayMetrics.heightPixels

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = BottomSheetSearchTicketBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //Get the bottom_sheet of the system
        val view: FrameLayout = dialog?.findViewById(R.id.design_bottom_sheet)!!
        //Set the view height
        view.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        //Get behavior
        val behavior = BottomSheetBehavior.from(view)
        //Set the pop-up height
        behavior.peekHeight = getWindowHeight()
        //Set the expanded state
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    //dismiss()
                    dismiss()
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etFromWher.text = localStorage.lastInputCity

        binding.ivClear.setOnClickListener {
            binding.etPlaceOfArrival.text.clear()
        }

        binding.tip1.setOnClickListener {
            tipClickListener.invoke()
            dismiss()
        }

        binding.tip3.setOnClickListener {
            tipClickListener.invoke()
            dismiss()
        }

        binding.tip4.setOnClickListener {
            tipClickListener.invoke()
            dismiss()
        }

        binding.tip2.setOnClickListener {
            onAnywhereItemClickListener.invoke(getString(R.string.anywhere))
            dismiss()
        }

        binding.llSochi.setOnClickListener {
            onAnywhereItemClickListener.invoke(getString(R.string.sochi))
            dismiss()
        }

        binding.llStambul.setOnClickListener {
            onAnywhereItemClickListener.invoke(getString(R.string.stambul))
            dismiss()
        }

        binding.llPhuket.setOnClickListener {
            onAnywhereItemClickListener.invoke(getString(R.string.phuket))
            dismiss()
        }

    }

    private var onAnywhereItemClickListener: (nameOfCity: String) -> Unit = {}
    fun setOnAnywhereItemClickListener(aa: (nameOfCity: String) -> Unit) {
        onAnywhereItemClickListener = aa
    }

    private var tipClickListener: () -> Unit = {}
    fun setOnTipClickListener(aa: () -> Unit) {
        tipClickListener = aa
    }

}