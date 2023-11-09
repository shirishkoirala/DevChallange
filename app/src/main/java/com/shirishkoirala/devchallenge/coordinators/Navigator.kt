package com.shirishkoirala.devchallenge.coordinators

import androidx.fragment.app.FragmentActivity
import com.shirishkoirala.devchallenge.R
import com.shirishkoirala.devchallenge.detailscreen.DetailScreenFragment
import com.shirishkoirala.devchallenge.homescreen.HomeScreenFragment

class Navigator(var activity: FragmentActivity?) {

    fun showPopularMovies() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, HomeScreenFragment())
            ?.commit()
    }

    fun showDetailPage(movieId: Int) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, DetailScreenFragment())?.commit()
    }

    fun destroy() {
        activity = null
    }
}