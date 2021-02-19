package com.example.miner_clicker.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.data2.ore.Ore
import com.example.miner_clicker.data2.ore.OreViewModel
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerViewModel
import com.example.miner_clicker.data2.storage.Storage
import com.example.miner_clicker.data2.storage.StorageViewModel
import kotlin.math.absoluteValue


class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel,
                               private var mPlayerViewModel: PlayerViewModel,
                               private var mOreViewModel: OreViewModel):ViewModel() {
    lateinit var players: LiveData<List<Player>>
    private lateinit var ore : Ore


    init {

    }


    fun click() {
        ore.currentHealth--
        if(ore.currentHealth<=0){
            setOreNewLevel()
        }
        mOreViewModel.updateOre(ore)


    }

    fun setOre(ore : Ore){
        this.ore = ore
    }
    fun setOreNewLevel(){
        ore.maxHealth+=5
        ore.currentHealth=ore.maxHealth
        ore.level++
        ore.capacity+=5

    }
}
