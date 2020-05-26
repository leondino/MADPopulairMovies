package com.example.populairmovies.database

import java.time.Year

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMostPopulairMovies(year: String) = moviesApi.getMostPopulairMovies(year)
}