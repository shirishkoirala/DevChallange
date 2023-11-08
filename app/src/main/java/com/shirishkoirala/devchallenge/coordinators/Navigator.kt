package com.shirishkoirala.devchallenge.coordinators

import androidx.fragment.app.FragmentActivity
import com.shirishkoirala.devchallenge.R
import com.shirishkoirala.devchallenge.homescreen.HomeScreenFragment

class Navigator {
    var activity: FragmentActivity? = null

    fun showPopularMovies() {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, HomeScreenFragment())
            .commit()
    }
}