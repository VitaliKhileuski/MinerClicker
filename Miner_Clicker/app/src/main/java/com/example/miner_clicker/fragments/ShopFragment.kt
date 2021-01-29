package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miner_clicker.models.Pickaxe
import com.example.miner_clicker.adapters.ShopRecyclerAdapter
import com.example.miner_clicker.databinding.FragmentShopBinding
import com.example.miner_clicker.viewModels.ShopFragmentVM

class ShopFragment : Fragment() {
    private var _binding:FragmentShopBinding?=null
    private val binding get() = _binding!!
    private var products = mutableListOf<Pickaxe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentShopBinding.inflate(inflater, container, false)

        var product1: Pickaxe = Pickaxe()
        addToList(product1)
        var product2: Pickaxe = Pickaxe()
        addToList(product2)
        var product3: Pickaxe = Pickaxe()
        addToList(product3)
        var product4: Pickaxe = Pickaxe()
        addToList(product4)
        binding.lifecycleOwner=this
        binding.viewModel= ShopFragmentVM()
        binding.shopRecyclerView.layoutManager=LinearLayoutManager(this.context)
        binding.shopRecyclerView.adapter=ShopRecyclerAdapter(products)

        return binding.root
    }

    private fun addToList(product: Pickaxe){
        products.add(product)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}