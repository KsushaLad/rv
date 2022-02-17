package com.example.list

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.RecyclerviewItemBinding

class ItemAdapter : ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.largeTextView.text =  currentList[position].name//submitList(item).toString()
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(holder.largeTextView.context, DetailsActivity::class.java)
            intent.putExtra("all", currentList[position].toString()) //currentList[position]
            v.context.startActivity(intent)
        }
    }

    inner class ItemViewHolder(binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val largeTextView: TextView = binding.textViewLarge
    }

    class ItemDiffUtil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}