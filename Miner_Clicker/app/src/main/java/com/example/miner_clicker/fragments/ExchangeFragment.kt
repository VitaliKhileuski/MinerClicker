package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miner_clicker.R
import com.example.miner_clicker.databinding.FragmentExchangeBinding
import com.example.miner_clicker.viewModels.ExchangeFragmentVM


class ExchangeFragment : Fragment() {
    private var _binding:FragmentExchangeBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentExchangeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=this
        binding.viewModel= ExchangeFragmentVM()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}