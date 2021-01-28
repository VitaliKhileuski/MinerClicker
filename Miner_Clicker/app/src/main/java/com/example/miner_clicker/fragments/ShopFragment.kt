package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.Pickaxe
import com.example.miner_clicker.R
import com.example.miner_clicker.adapters.ShopRecyclerAdapter

class ShopFragment : Fragment() {

    private var products = mutableListOf<Pickaxe>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_shop, container, false)

        var product1: Pickaxe = Pickaxe()
        addToList(product1)
        var product2: Pickaxe = Pickaxe()
        addToList(product2)
        var product3: Pickaxe = Pickaxe()
        addToList(product3)
        var product4: Pickaxe = Pickaxe()
        addToList(product4)

        recyclerView = v.findViewById(R.id.shop_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = ShopRecyclerAdapter(products)

        return v
    }

    private fun addToList(product: Pickaxe){
        products.add(product)
    }
}