package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.R
import com.example.miner_clicker.StorageItem
import com.example.miner_clicker.adapters.StorageRecyclerAdapter


class StorageFragment : Fragment() {

    private var resources = mutableListOf<StorageItem>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val resource1: StorageItem = StorageItem()
        resource1.capacity = 250
        resource1.numberOfMineral = 100
        addToList(resource1)

        val resource2: StorageItem = StorageItem()
        resource1.capacity = 250
        resource1.numberOfMineral = 150
        addToList(resource2)

        recyclerView = this.view!!.findViewById(R.id.storage_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = StorageRecyclerAdapter(resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_storage, container, false)
    }

    private fun addToList(resource: StorageItem){
        resources.add(resource)
    }
}