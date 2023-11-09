package com.shirishkoirala.devchallenge.ui.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.FragmentDetailScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailScreenFragment : Fragment() {
    private lateinit var binding: FragmentDetailScreenBinding
    private lateinit var navigator: Navigator
    private lateinit var viewModel: DetailScreenViewModel

    @Inject
    lateinit var viewModelFactory: DetailScreenViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navigator = Navigator(requireActivity())

        viewModel = ViewModelProvider(this, viewModelFactory)[DetailScreenViewModel::class.java]

        val movieId = arguments?.getInt("movie_id")
        if (movieId != null) {
            viewModel.getMovieDetail(movieId)
        }

        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            navigator.showPopularMovies()
        }

        viewModel.movieDetail.observe(viewLifecycleOwner) {
            binding.title.text = it.title
            Glide.with(this).load(it.posterPath).into(binding.posterImage)
            binding.overview.text = it.overview
            Glide.with(this).load(it.backdropPath).into(binding.backdrop)
        }
        return binding.root
    }
}