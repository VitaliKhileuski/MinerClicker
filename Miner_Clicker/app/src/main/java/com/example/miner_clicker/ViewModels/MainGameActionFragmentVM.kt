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
import com.example.miner_clicker.models.gameComponents.RandomMinerals
import kotlin.math.absoluteValue


class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel,
                               private var mPlayerViewModel: PlayerViewModel,
                               private var mOreViewModel: OreViewModel):ViewModel() {
    private lateinit var ore : Ore
    private lateinit var storage : List<Storage>

    init {

    }


    fun click() {
        ore.currentHealth--
        if(ore.currentHealth<=0){
            setMinerals()
            setOreNewLevel()

        }
        mOreViewModel.updateOre(ore)


    }

    fun setOre(ore : Ore){
        this.ore = ore
    }
    fun setStorage(storage : List<Storage>){
        this.storage = storage
    }
    private fun setOreNewLevel(){
        ore.maxHealth+=5
        ore.currentHealth=ore.maxHealth
        ore.level++
        ore.capacity+=5
    }
    private fun setMinerals(){
    RandomMinerals.getStorageItems(storage,ore.capacity)
        mStorageViewModel.updateAllData(storage)
    }
}
