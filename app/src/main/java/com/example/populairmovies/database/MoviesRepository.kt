package com.example.populairmovies.database

import java.time.Year

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMostPopulairMovies(year: Int) = moviesApi.getMostPopulairMovies(year)

    fun getApiConfigurations() = moviesApi.getApiConfiguration()
}