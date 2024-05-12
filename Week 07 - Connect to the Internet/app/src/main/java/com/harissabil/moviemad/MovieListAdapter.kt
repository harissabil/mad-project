package com.harissabil.moviemad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.harissabil.moviemad.data.response.ResultsItem
import com.harissabil.moviemad.databinding.ItemMovieBinding

class MovieListAdapter(
    private val list: List<ResultsItem>,
) : RecyclerView.Adapter<MovieListAdapter.ViewHoler>() {

    inner class ViewHoler(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHoler(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        val movie = list[position]

        holder.binding.ivPoster.load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
        holder.binding.tvTitle.text = movie.title
        holder.binding.tvReleaseDate.text = movie.releaseDate
    }
}