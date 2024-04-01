package com.vivianegomes.vivacecafe.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vivianegomes.vivacecafe.databinding.PopularItemBinding

class PopularAdapter (private val items: List<String>, private val preco: List<String>,private val image:List<Int>): RecyclerView.Adapter<PopularAdapter.PouplerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
        return PouplerViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val preco = preco[position]
        val images = image[position]

        holder.bind(item,preco, images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PouplerViewHolder(private val binding: PopularItemBinding): RecyclerView.ViewHolder(binding.root){

        private val imagesView = binding.imgViewPopular

        fun bind(item: String, preco: String,images: Int){
            binding.foodnamePopular.text = item
            binding.precoPopular.text = preco
            imagesView.setImageResource(images)
        }
    }



}