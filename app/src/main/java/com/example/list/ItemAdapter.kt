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
        val item = mutableListOf<Item>()
        for (i in 0 .. 20){
            item.add(Item( i, "$i",  "$i"))
        }
        holder.largeTextView.text =  names()[position]//submitList(item).toString()
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(holder.largeTextView.context, DetailsActivity::class.java)
            intent.putExtra("all", list()[position]) //currentList[position]
            v.context.startActivity(intent)
        }
    }

    private fun names() : List<String>{
        val data = mutableListOf<String>()
        (0 until 20).map{
            data.add("name=$it").toString() }
        return data
    }

    private fun list() : List<String>{
        val data = mutableListOf<String>()
        (0 until 20).map{
            data.add(Item( it, "$it",  "$it").toString() )}
        return data
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

   override fun getItemCount() = list().size //delete

}