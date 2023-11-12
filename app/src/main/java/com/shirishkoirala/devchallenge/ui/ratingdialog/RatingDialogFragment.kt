package com.shirishkoirala.devchallenge.ui.ratingdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shirishkoirala.devchallenge.R
import com.shirishkoirala.devchallenge.databinding.FragmentRatingDialogBinding

class RatingDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentRatingDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRatingDialogBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}