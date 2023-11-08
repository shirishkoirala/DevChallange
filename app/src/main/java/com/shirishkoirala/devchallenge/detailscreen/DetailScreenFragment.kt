package com.shirishkoirala.devchallenge.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shirishkoirala.devchallenge.databinding.FragmentDetailScreenBinding

class DetailScreenFragment : Fragment() {
    private lateinit var binding: FragmentDetailScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}