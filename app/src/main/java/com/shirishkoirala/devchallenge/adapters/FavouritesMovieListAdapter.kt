package com.shirishkoirala.devchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shirishkoirala.devchallenge.databinding.HorizontalListItemBinding
import com.shirishkoirala.devchallenge.models.Movie

class FavouritesMovieListAdapter(
    private val movies: List<Movie>,
    private val listener: (Int?) -> Unit
) : RecyclerView.Adapter<FavouritesMovieListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouritesMovieListAdapter.ViewHolder {
        return ViewHolder(
            HorizontalListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavouritesMovieListAdapter.ViewHolder, position: Int) {
        val item = movies[position]
        Glide.with(holder.root).load(item.posterPath).centerCrop().into(holder.image)
        holder.root.setOnClickListener { listener(item.id) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(binding: HorizontalListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.posterImage
        val favButton = binding.favButton
        val root: View = binding.root
    }
}