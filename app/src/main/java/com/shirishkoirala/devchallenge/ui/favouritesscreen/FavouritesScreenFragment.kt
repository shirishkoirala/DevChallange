package com.shirishkoirala.devchallenge.ui.favouritesscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shirishkoirala.devchallenge.databinding.FragmentFavouritesScreenBinding

class FavouritesScreenFragment : Fragment() {
    private lateinit var binding: FragmentFavouritesScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesScreenBinding.inflate(inflater)
        return binding.root
    }
}