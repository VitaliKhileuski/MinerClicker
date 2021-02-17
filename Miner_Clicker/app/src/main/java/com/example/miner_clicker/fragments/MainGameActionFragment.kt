package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.miner_clicker.adapters.ConvertBigNumbers
import com.example.miner_clicker.data2.player.PlayerViewModel
import com.example.miner_clicker.data2.storage.StorageViewModel
import com.example.miner_clicker.databinding.FragmentMainGameActionBinding
import com.example.miner_clicker.viewModels.MainGameActionFragmentVM

class MainGameActionFragment(var mStorageViewModel: StorageViewModel, var mPlayerViewModel: PlayerViewModel) : Fragment() {

    private var _binding: FragmentMainGameActionBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainGameActionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = MainGameActionFragmentVM(mStorageViewModel, mPlayerViewModel)
        mPlayerViewModel.allData.observe(viewLifecycleOwner, Observer { players ->
            players?.let {
                binding.money.text = ConvertBigNumbers.ToString(players[0].money)
                binding.gems.text = players[0].gems.toString()
                (binding.viewModel as MainGameActionFragmentVM).setMoney(players[0].money)
            }
        })

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}