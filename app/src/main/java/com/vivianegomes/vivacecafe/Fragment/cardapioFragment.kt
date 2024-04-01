package com.vivianegomes.vivacecafe.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vivianegomes.vivacecafe.R
import com.vivianegomes.vivacecafe.adaptar.CardapioAdapter
import com.vivianegomes.vivacecafe.adaptar.CarrinhoAdapter
import com.vivianegomes.vivacecafe.databinding.FragmentCardapioBinding
import com.vivianegomes.vivacecafe.databinding.FragmentHomeBinding

class cardapioFragment : Fragment() {
    private lateinit var binding: FragmentCardapioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardapioBinding.inflate(inflater, container, false)

        val cardapioNomeComida = listOf("Café", "Capuccino","Chá", "item")
        val cardapioItemPreco = listOf("R$2,50", "R$5,00", "R$1,50", "R$0,05")
        val tempoPreparo = listOf("2 minutos", "5 minutos", "3 minutos", "x minutos")
        val cardapioImagens = listOf(
            R.drawable.img_capuccino1,
            R.drawable.img_capuccino1,
            R.drawable.img_capuccino1,
            R.drawable.img_capuccino1
        )

        val adapter = CardapioAdapter(ArrayList(cardapioNomeComida), ArrayList(cardapioItemPreco), ArrayList(tempoPreparo),ArrayList(cardapioImagens))
        binding.CardapioRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.CardapioRecylerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
    }

}