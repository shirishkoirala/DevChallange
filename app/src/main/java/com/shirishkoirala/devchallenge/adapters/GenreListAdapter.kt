package com.shirishkoirala.devchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shirishkoirala.devchallenge.databinding.LayoutPillListItemBinding
import com.shirishkoirala.devchallenge.models.Genre

class GenreListAdapter(
    private val genres: List<Genre>,
) : RecyclerView.Adapter<GenreListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreListAdapter.ViewHolder {
        return ViewHolder(
            LayoutPillListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreListAdapter.ViewHolder, position: Int) {
        val item = genres[position]
        holder.name.text = item.name
    }

    override fun getItemCount(): Int {
        return genres.size
    }

    inner class ViewHolder(binding: LayoutPillListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val root: View = binding.root
    }
}