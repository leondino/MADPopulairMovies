package com.example.populairmovies.database

import com.example.populairmovies.model.ConfigurationsResult
import com.example.populairmovies.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface MoviesApiService {

    @GET("3/discover/movie?api_key=$apiKey&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMostPopulairMovies(@Query("year") year: Int): Call<Result>

    @GET("https://api.themoviedb.org/3/configuration?api_key=$apiKey")
    fun getApiConfiguration(): Call<ConfigurationsResult>

    companion object {
        private const val apiKey = "3d6c860dbe9b18777a3c63c5cca2aab9"
    }
}