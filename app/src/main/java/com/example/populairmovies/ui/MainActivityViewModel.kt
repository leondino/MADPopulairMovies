package com.example.populairmovies.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.populairmovies.database.MoviesRepository
import com.example.populairmovies.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Year

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val moviesRepository = MoviesRepository()
    val result = MutableLiveData<Result>()
    val error = MutableLiveData<String>()

    fun getPopulairMovies(year: Int){
        moviesRepository.getMostPopulairMovies(year).enqueue(object : Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.isSuccessful) result.value = response.body()
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}