package com.example.miner_clicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miner_clicker.data2.storage.StorageViewModel
import com.example.miner_clicker.databinding.FragmentMainGameActionBinding
import com.example.miner_clicker.viewModels.MainGameActionFragmentVM


class MainGameActionFragment(var mStorageViewModel: StorageViewModel) : Fragment() {
    private var _binding:FragmentMainGameActionBinding?=null
<<<<<<< HEAD
    private val binding get() = _binding!!
    //private val dataBase=database
=======
    public val binding get() = _binding!!
    private val dataBase=database
>>>>>>> 820f35bcbbaab7c57f0cc76146e0bf3b412ceb37

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainGameActionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=this
        binding.viewModel= MainGameActionFragmentVM(mStorageViewModel)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}