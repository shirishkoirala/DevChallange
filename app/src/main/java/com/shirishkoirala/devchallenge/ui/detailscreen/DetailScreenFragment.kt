package com.shirishkoirala.devchallenge.ui.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.shirishkoirala.devchallenge.R
import com.shirishkoirala.devchallenge.adapters.GenreListAdapter
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.FragmentDetailScreenBinding
import com.shirishkoirala.devchallenge.ui.ratingdialog.RatingDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailScreenFragment : Fragment() {
    private lateinit var binding: FragmentDetailScreenBinding
    private lateinit var navigator: Navigator
    private lateinit var viewModel: DetailScreenViewModel

    @Inject
    lateinit var viewModelFactory: DetailScreenViewModelFactory
    private var movieId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navigator = Navigator(requireActivity())

        viewModel = ViewModelProvider(this, viewModelFactory)[DetailScreenViewModel::class.java]

        movieId = arguments?.getInt("movie_id")
        movieId?.let {
            viewModel.getMovieDetail(it)
            viewModel.checkIfFavourite(it)
        }

        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            navigator.showPopularMovies()
        }

        viewModel.movieDetail.observe(viewLifecycleOwner) { movie ->
            binding.title.text = movie.title
            Glide.with(this).load(movie.posterPath).into(binding.posterImage)
            binding.overview.text = movie.overview
            Glide.with(this).load(movie.backdropPath).into(binding.backdrop)
            binding.heroTitle.text = movie.title
            binding.userScore.text = "${movie.userScore} % User Score"
            movie.userScore?.toInt()?.let {
                binding.rating.progress = it
            }
            binding.date.text = movie.year
            binding.genreList.adapter = movie.genres?.let { GenreListAdapter(it) }
        }

        binding.viewFavButton.setOnClickListener {
            navigator.showFavourites()
        }

        binding.favButton.setOnClickListener {
            movieId?.let { movieId ->
                viewModel.isFavourite.value?.let { isFavourite ->
                    viewModel.setFavourite(movieId, !isFavourite)
                }
            }
        }

        binding.rateItMyselfCard.setOnClickListener {
            movieId?.let {
                val bundle = Bundle()
                bundle.putInt("movie_id", it)
                val rateDialog = RatingDialogFragment()
                rateDialog.arguments = bundle
                rateDialog.show(parentFragmentManager, "BottomSheet")
            }
        }

        viewModel.isFavourite.observe(viewLifecycleOwner) {
            if (it) {
                binding.favButton.setImageResource(R.drawable.star_fill)
            } else {
                binding.favButton.setImageResource(R.drawable.star_outline)
            }
        }
        return binding.root
    }
}