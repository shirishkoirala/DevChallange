package com.shirishkoirala.devchallenge.ui.favouritesscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shirishkoirala.devchallenge.R
import com.shirishkoirala.devchallenge.adapters.FavouritesMovieListAdapter
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.FragmentFavouritesScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavouritesScreenFragment : Fragment() {
    private lateinit var binding: FragmentFavouritesScreenBinding
    private lateinit var viewModel: FavouritesScreenViewModel

    @Inject
    lateinit var viewModelFactory: FavouritesScreenViewModelFactory
    lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesScreenBinding.inflate(inflater)
        navigator = Navigator(requireActivity())
        viewModel = ViewModelProvider(this, viewModelFactory)[FavouritesScreenViewModel::class.java]
        viewModel.getFavouriteMovies(20678273)
        viewModel.favouriteMoviesList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.button.text = "Search for More"
                binding.button.setOnClickListener {
                    navigator.showPopularMovies()
                }

                binding.topBar.background =
                    ContextCompat.getDrawable(requireContext(), R.color.mint_green)
                binding.title.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.dark_teal
                    )
                )

                binding.emptyList.visibility = View.GONE
                binding.recyclerView.adapter = FavouritesMovieListAdapter(it) { movieId ->
                }
                binding.recyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            } else {
                binding.emptyList.visibility = View.VISIBLE
                binding.button.text = "Search for a Favourite"
                binding.button.setOnClickListener {
                    navigator.showPopularMovies()
                }
            }
        }
        binding.backButton.setOnClickListener {
            navigator.showPopularMovies()
        }
        return binding.root
    }
}