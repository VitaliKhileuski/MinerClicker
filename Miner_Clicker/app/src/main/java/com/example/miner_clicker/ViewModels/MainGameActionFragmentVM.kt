package com.example.miner_clicker.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerViewModel
import com.example.miner_clicker.data2.storage.Storage
import com.example.miner_clicker.data2.storage.StorageViewModel
import kotlin.math.absoluteValue


class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel,
                               private var mPlayerViewModel: PlayerViewModel):ViewModel() {
    lateinit var players: LiveData<List<Player>>
    private var money = MutableLiveData<Int>()
    public val Money: LiveData<Int> = money

    init {
    money.value= mStorageViewModel.readAllData.
    }


    fun click() {
        // player.money+=1
        //mPlayerViewModel.updatePlayer(player)
    }
}
