package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miner_clicker.R
import com.example.miner_clicker.databinding.FragmentDrillBinding
import com.example.miner_clicker.viewModels.DrillFragmentVM


class DrillFragment : Fragment() {
    private var _binding:FragmentDrillBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentDrillBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=this
        binding.viewModel= DrillFragmentVM()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}