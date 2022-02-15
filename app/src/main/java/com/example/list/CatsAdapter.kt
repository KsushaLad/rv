package com.example.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.RecyclerviewItemBinding

class CatsAdapter(private val w: List<String>, private val r: MutableList<Item?>) :
    ListAdapter<Item, CatsAdapter.CatViewHolder>(PersonDiffUtil()) { //ListAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
     return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.largeTextView.text = w[position] //submitList(r).toString()
        holder.itemView.setOnClickListener { v ->
       val context = holder.largeTextView.context
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("id", w[position]) //currentList[position]
            intent.putExtra("name", w[position]) //currentList[position]
            intent.putExtra("description", w[position]) //currentList[position]
            v.context.startActivity(intent)
        }
    }


    inner class CatViewHolder(binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val largeTextView: TextView = binding.textViewLarge
    }

    class PersonDiffUtil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemCount() = w.size //delete
}