package com.shirishkoirala.devchallenge.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shirishkoirala.devchallenge.adapters.MovieListAdapter
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeScreenViewModel

    @Inject
    lateinit var viewModelFactory: HomeScreenViewModelFactory

    lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        navigator = Navigator(requireActivity())
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeScreenViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.loader.observe(viewLifecycleOwner) { loading ->
            when (loading) {
                true -> binding.loading.visibility = View.VISIBLE
                false -> binding.loading.visibility = View.GONE
            }
        }

        viewModel.popularList.observe(viewLifecycleOwner) { movies ->
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter =
                MovieListAdapter(movies = movies, listener = {
                    it?.let {
                        navigator.showDetailPage(it)
                    }
                })
        }
        return binding.root;
    }
}