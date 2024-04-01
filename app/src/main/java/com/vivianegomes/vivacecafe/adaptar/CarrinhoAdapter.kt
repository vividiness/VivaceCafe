package com.vivianegomes.vivacecafe.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.vivianegomes.vivacecafe.Fragment.carrinhoFragment
import com.vivianegomes.vivacecafe.databinding.CarrinhoItemBinding

class CarrinhoAdapter(
    private val carrinhoItens: MutableList<String>,
    private val carrinhoItemPreco: MutableList<String>,
    private val carrinhoImagem: MutableList<Int>
) : RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    private val quantidadeItens = IntArray(carrinhoItens.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        val binding =
            CarrinhoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarrinhoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = carrinhoItens.size

    inner class CarrinhoViewHolder(private val binding: CarrinhoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantidade = quantidadeItens[position]
                itemCarrinhoNome.text = carrinhoItens[position]
                itemcarrinhoPreco.text = carrinhoItemPreco[position]
                itemCarrinhoImagem.setImageResource(carrinhoImagem[position])
                itemQuantidade.text = quantidade.toString()

                btnMinus.setOnClickListener {
                    diminuirQuantidadeItem(position)
                }

                btnPlus.setOnClickListener {
                    acrescentarQuantidadeItem(position)
                }

                btnDelete.setOnClickListener {
                    val posicaoItem = adapterPosition
                    if(posicaoItem != RecyclerView.NO_POSITION){
                        excluirTem(posicaoItem)
                    }
                }
            }

        }

        private fun excluirTem(posicao: Int) {
            carrinhoItens.removeAt(posicao)
            carrinhoImagem.removeAt(posicao)
            carrinhoItemPreco.removeAt(posicao)
            notifyItemRemoved(posicao)
            notifyItemRangeChanged(posicao, carrinhoImagem.size)

        }

        private fun acrescentarQuantidadeItem(posicao: Int) {
            if (quantidadeItens[posicao] < 10) {
                quantidadeItens[posicao]++
                binding.itemQuantidade.text = quantidadeItens[posicao].toString()
            }
        }

        fun diminuirQuantidadeItem(posicao: Int) {
            if (quantidadeItens[posicao] > 1) {
                quantidadeItens[posicao]--
                binding.itemQuantidade.text = quantidadeItens[posicao].toString()
            }
        }

    }
}