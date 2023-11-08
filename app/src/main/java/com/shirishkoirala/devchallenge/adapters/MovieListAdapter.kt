package com.shirishkoirala.devchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shirishkoirala.devchallenge.databinding.LayoutListItemBinding
import com.shirishkoirala.devchallenge.models.Movie

class MovieListAdapter(
    private val movies: List<Movie>,
    private val listener: (String) -> Unit
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
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(binding: LayoutListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
        val root: View = binding.root
    }
}