package com.vivianegomes.vivacecafe.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vivianegomes.vivacecafe.R
import com.vivianegomes.vivacecafe.adaptar.CarrinhoAdapter
import com.vivianegomes.vivacecafe.databinding.FragmentCarrinhoBinding

class carrinhoFragment : Fragment() {
    private lateinit var binding:FragmentCarrinhoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarrinhoBinding.inflate(inflater, container, false)

        val carrinhoNomeComida = listOf("Café", "Capuccino","Chá", "item")
        val carrinhoItemPreco = listOf("R$2,50", "R$5,00", "R$1,50", "R$0,05")
        val carrinhoImagens = listOf(
            R.drawable.img_capuccino1,
            R.drawable.img_capuccino1,
            R.drawable.img_capuccino1,
            R.drawable.img_capuccino1
        )
        val adapter = CarrinhoAdapter(ArrayList(carrinhoNomeComida), ArrayList(carrinhoItemPreco), ArrayList(carrinhoImagens))
        binding.carrinhoRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.carrinhoRecycleView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}