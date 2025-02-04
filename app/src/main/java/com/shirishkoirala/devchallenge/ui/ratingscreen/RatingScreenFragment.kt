package com.shirishkoirala.devchallenge.ui.ratingscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shirishkoirala.devchallenge.databinding.FragmentRatingScreenBinding

class RatingScreenFragment : Fragment() {
    private lateinit var binding: FragmentRatingScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRatingScreenBinding.inflate(inflater)
        return binding.root
    }
}