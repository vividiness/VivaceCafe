package com.vivianegomes.vivacecafe.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.vivianegomes.vivacecafe.R
import com.vivianegomes.vivacecafe.adaptar.PopularAdapter
import com.vivianegomes.vivacecafe.databinding.FragmentHomeBinding


class homeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner4, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int){
                val itemPosition = imageList[position]
                val itemMessage="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Café", "Capuccino", "Chá", "item")
        val precos = listOf("R$2,50", "R$5,00", "R$1,50", "R$0,05")
        val popularCafesImagens =
            listOf(R.drawable.img_capuccino1, R.drawable.img_capuccino1, R.drawable.img_capuccino1, R.drawable.img_capuccino1)

        val adapter = PopularAdapter(foodName, precos, popularCafesImagens)
        binding.popularRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecylerView.adapter = adapter

    }
    companion object{

    }
}