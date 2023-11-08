package com.shirishkoirala.devchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shirishkoirala.devchallenge.databinding.LayoutListItemBinding
import com.shirishkoirala.devchallenge.models.Movie

class MovieListAdapter(
    private val movies: List<Movie>,
    private val listener: (Int?) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {
        return ViewHolder(
            LayoutListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int) {
        val item = movies[position]
        holder.title.text = item.title
        holder.year.text = item.year
        holder.userScore.text = "${item.userScore}% User Score"
        Glide.with(holder.root).load(item.posterPath).centerCrop().into(holder.image)
        holder.root.setOnClickListener { listener(item.id) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(binding: LayoutListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
        val year: TextView = binding.year
        val userScore: TextView = binding.percent
        val image: ImageView = binding.image
        val root: View = binding.root
    }
}