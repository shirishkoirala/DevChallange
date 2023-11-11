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
import com.shirishkoirala.devchallenge.databinding.FragmentFavouritesScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavouritesScreenFragment : Fragment() {
    private lateinit var binding: FragmentFavouritesScreenBinding
    private lateinit var viewModel: FavouritesScreenViewModel

    @Inject
    lateinit var viewModelFactory: FavouritesScreenViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesScreenBinding.inflate(inflater)
        viewModel = ViewModelProvider(this, viewModelFactory)[FavouritesScreenViewModel::class.java]
        viewModel.getFavouriteMovies(20678273)
        viewModel.favouriteMoviesList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.topBar.background = ContextCompat.getDrawable(requireContext(), R.color.mint_green)
                binding.title.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_teal))

                binding.emptyList.visibility = View.GONE
                binding.recyclerView.adapter = FavouritesMovieListAdapter(it) {

                }
                binding.recyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            } else {
                binding.emptyList.visibility = View.VISIBLE
            }
        }
        return binding.root
    }
}