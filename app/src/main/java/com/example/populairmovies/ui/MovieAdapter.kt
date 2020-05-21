package com.example.populairmovies.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.populairmovies.R
import com.example.populairmovies.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies: List<Movie>, private  val onClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                onClick(movies[adapterPosition])
            }
        }
        fun bind(movie: Movie){
            itemView.tvNumber.text = movies[adapterPosition].toString() + '.'
            Glide.with(context).load(movie.poster_path).into(itemView.ivMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(movies[position])
    }
}