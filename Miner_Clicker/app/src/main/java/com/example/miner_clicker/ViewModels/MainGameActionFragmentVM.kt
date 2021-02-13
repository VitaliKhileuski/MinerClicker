package com.example.miner_clicker.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerViewModel
import com.example.miner_clicker.data2.storage.StorageViewModel


class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel,
                                private var mPlayerViewModel: PlayerViewModel):ViewModel() {
    lateinit var players : LiveData<List<Player>>

    init{
        players = mPlayerViewModel.readAllData
    }



}

