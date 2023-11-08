package com.shirishkoirala.devchallenge.coordinators

class MainFlowCoordinator(
    private val navigator: Navigator
) {
    fun start() {
        navigator.showPopularMovies()
    }
}