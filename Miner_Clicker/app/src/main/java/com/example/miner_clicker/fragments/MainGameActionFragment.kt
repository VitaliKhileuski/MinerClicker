package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miner_clicker.dataBase.DataBase
import com.example.miner_clicker.databinding.FragmentMainGameActionBinding
import com.example.miner_clicker.viewModels.MainGameActionFragmentVM


class MainGameActionFragment(database : DataBase, var storageFragment: StorageFragment) : Fragment() {
    private var _binding:FragmentMainGameActionBinding?=null
    public val binding get() = _binding!!
    private val dataBase=database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainGameActionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=this
        binding.viewModel= MainGameActionFragmentVM(dataBase, storageFragment)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}