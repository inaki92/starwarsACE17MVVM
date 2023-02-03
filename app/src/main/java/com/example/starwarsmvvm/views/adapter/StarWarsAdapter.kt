package com.example.starwarsmvvm.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsmvvm.databinding.StarWarsItemBinding

class StarWarsAdapter(
    private val itemSet: MutableList<com.example.starwarsmvvm.model.Result> = mutableListOf(),
    private val onItemClick: (itemId: String) -> Unit
) :  RecyclerView.Adapter<StarWarsViewHolder>() {

    fun updateItems(newItems: List<com.example.starwarsmvvm.model.Result>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsViewHolder =
        StarWarsViewHolder(
            StarWarsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: StarWarsViewHolder, position: Int) =
        holder.bind(itemSet[position], onItemClick)

    override fun getItemCount(): Int = itemSet.size
}

class StarWarsViewHolder(
    private val binding: StarWarsItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: com.example.starwarsmvvm.model.Result, onItemClick: (String) -> Unit) {
        binding.itemName.text = item.name ?: "NO NAME PROVIDED"

        itemView.setOnClickListener {
            item.uid?.let(onItemClick)
        }
    }
}