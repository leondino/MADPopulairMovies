package com.example.populairmovies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.populairmovies.R
import com.example.populairmovies.model.Movie
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies) { movie -> onMovieClick(movie) }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViews(){
        rvMovies.layoutManager = GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false )
        rvMovies.adapter = movieAdapter
        btnSubmit.setOnClickListener{
            viewModel.getPopulairMovies(etYear.text.toString().toInt())
        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.result.observe(this, Observer{
            movies = it?.results as ArrayList<Movie>
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun onMovieClick(movie: Movie) {
        Snackbar.make(rvMovies, "This movie is called: ${movie.title}", Snackbar.LENGTH_LONG).show()
    }

}
