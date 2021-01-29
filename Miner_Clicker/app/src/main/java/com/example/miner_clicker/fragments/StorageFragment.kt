package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.models.gameComponents.StorageItem
import com.example.miner_clicker.adapters.StorageRecyclerAdapter
import com.example.miner_clicker.databinding.FragmentStorageBinding
import com.example.miner_clicker.viewModels.StorageFragmentVM


class StorageFragment : Fragment() {
    private var _binding:FragmentStorageBinding?=null
    private val binding get() = _binding!!
    private var resources = mutableListOf<StorageItem>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStorageBinding.inflate(inflater, container, false)

        val resource1: StorageItem = StorageItem()
        resource1.capacity = 250
        resource1.numberOfMineral = 100
        addToList(resource1)

        val resource2: StorageItem = StorageItem()
        resource1.capacity = 250
        resource1.numberOfMineral = 150
        addToList(resource2)

        val resource3: StorageItem = StorageItem()
        resource1.capacity = 250
        resource1.numberOfMineral = 150
        addToList(resource3)

        val resource4: StorageItem = StorageItem()
        resource1.capacity = 250
        resource1.numberOfMineral = 150
        addToList(resource4)
        binding.lifecycleOwner=this
        binding.viewModel= StorageFragmentVM()
        binding.storageRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.storageRecyclerView.adapter = StorageRecyclerAdapter(resources)

        return binding.root
    }

    private fun addToList(resource: StorageItem){
        resources.add(resource)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}