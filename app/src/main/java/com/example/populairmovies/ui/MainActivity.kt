package com.example.populairmovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.populairmovies.R
import com.example.populairmovies.model.Movie
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_movie.*

const val EXTRA_MOVIE = "EXTRA_MOVIE"

class MainActivity : AppCompatActivity() {

    private var movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies,this) { movie -> onMovieClick(movie) }
    public lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViews(){
        rvMovies.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false )
        rvMovies.adapter = movieAdapter
        btnSubmit.setOnClickListener{
            viewModel.getPopulairMovies(etYear.text.toString().toInt())
        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.result.observe(this, Observer{
            movies.clear()
            movies.addAll(it.results)
            //Give position number so it can be used in bind method of recycler view
            for(movie in movies)
                movie.number = movies.indexOf(movie) + 1
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        viewModel.getApiConfigurations()
    }

    private fun onMovieClick(movie: Movie) {
        Snackbar.make(rvMovies, "This movie is called: ${movie.title}", Snackbar.LENGTH_LONG).show()
        val movieIntent = Intent(this, MovieActivity::class.java)
        movieIntent.putExtra(EXTRA_MOVIE, movie)
        startActivity(movieIntent)
    }

}
