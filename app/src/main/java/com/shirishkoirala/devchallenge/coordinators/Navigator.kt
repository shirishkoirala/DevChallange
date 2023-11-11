package com.shirishkoirala.devchallenge.coordinators

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.shirishkoirala.devchallenge.R
import com.shirishkoirala.devchallenge.ui.detailscreen.DetailScreenFragment
import com.shirishkoirala.devchallenge.ui.favouritesscreen.FavouritesScreenFragment
import com.shirishkoirala.devchallenge.ui.homescreen.HomeScreenFragment


class Navigator(var activity: FragmentActivity?) {

    fun showPopularMovies() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, HomeScreenFragment())
            ?.commit()
    }

    fun showDetailPage(movieId: Int) {
        val bundle = Bundle()
        bundle.putInt("movie_id", movieId)
        val detailScreenFragment = DetailScreenFragment()

        detailScreenFragment.arguments = bundle

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, detailScreenFragment)?.commit()
    }

    fun destroy() {
        activity = null
    }

    fun showFavourites() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, FavouritesScreenFragment())?.commit()
    }
}