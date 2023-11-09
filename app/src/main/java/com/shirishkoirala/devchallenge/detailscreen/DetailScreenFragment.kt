package com.shirishkoirala.devchallenge.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.FragmentDetailScreenBinding

class DetailScreenFragment : Fragment() {
    private lateinit var binding: FragmentDetailScreenBinding
    private lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navigator = Navigator(requireActivity())

        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        binding.backButton.setOnClickListener {
            navigator.showPopularMovies()
        }
        return binding.root
    }
}