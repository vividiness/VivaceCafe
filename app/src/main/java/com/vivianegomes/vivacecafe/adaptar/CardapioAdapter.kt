package com.vivianegomes.vivacecafe.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vivianegomes.vivacecafe.databinding.CardapioItemBinding

class CardapioAdapter(
    private val CardapioItemNome: MutableList<String>,
    private val CardapioPrecos: MutableList<String>,
    private val CardapioTempoPreparo: MutableList<String>,
    private val CardapioImagens: MutableList<Int>
) : RecyclerView.Adapter<CardapioAdapter.CardapioViewHolder>() {

    private val quantidadeItens = IntArray(CardapioItemNome.size) { 1 }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardapioAdapter.CardapioViewHolder {
        val binding =
            CardapioItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardapioViewHolder(binding)
    }

    override fun getItemCount(): Int = CardapioItemNome.size //?


    override fun onBindViewHolder(holder: CardapioAdapter.CardapioViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CardapioViewHolder(private val binding: CardapioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply{
                val qtd = quantidadeItens[position] //?

                cardapioItemNome.text= CardapioItemNome[position]
                cardapioTempopreparo.text = CardapioTempoPreparo[position]
                cardapioValor.text = CardapioPrecos[position]
                cardapioImagem.setImageResource(CardapioImagens[position])
            }
        }
    }

}

