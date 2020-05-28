package com.example.populairmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.populairmovies.R
import com.example.populairmovies.model.ImageConfigurations
import com.example.populairmovies.model.Movie
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews(){
        val intent = intent
        val imageConfigurations = intent.getParcelableExtra<ImageConfigurations>(EXTRA_CONFIGURATIONS)
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        tvRating.text = movie?.vote_average.toString()
        tvSummary.text = movie?.overview
        tvTitle.text = movie?.title
        tvRelease.text = getString(R.string.release_date, movie?.release_date)
        Glide.with(this).load(imageConfigurations?.base_url+
                imageConfigurations?.poster_sizes?.get(3)+
                movie?.poster_path).into(ivPoster)
        Glide.with(this).load(imageConfigurations?.base_url+
                imageConfigurations?.backdrop_sizes?.get(1)+
                movie?.backdrop_path).into(ivBackdrop)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
