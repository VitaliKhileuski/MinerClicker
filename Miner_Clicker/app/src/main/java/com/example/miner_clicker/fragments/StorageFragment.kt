package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miner_clicker.models.gameComponents.StorageItem
import com.example.miner_clicker.adapters.StorageRecyclerAdapter
import com.example.miner_clicker.databinding.FragmentStorageBinding
import com.example.miner_clicker.data2.Storage
import com.example.miner_clicker.data2.StorageViewModel


class StorageFragment(var mStorageViewModel: StorageViewModel) : Fragment() {
    private var _binding:FragmentStorageBinding?=null
    private val binding get() = _binding!!
    private var resources = mutableListOf<StorageItem>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentStorageBinding.inflate(inflater, container, false)



        binding.lifecycleOwner=this



        //binding.viewModel= StorageFragmentVM(database)
        val adapter = StorageRecyclerAdapter()
        binding.storageRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.storageRecyclerView.adapter = adapter
        mStorageViewModel.readAllData.observe(viewLifecycleOwner, Observer { storage ->
           adapter.SetData(storage)
        })


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