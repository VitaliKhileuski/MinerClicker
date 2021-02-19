package com.example.miner_clicker.viewModels


import androidx.lifecycle.ViewModel
import com.example.miner_clicker.databases.ore.Ore
import com.example.miner_clicker.databases.ore.OreViewModel
import com.example.miner_clicker.databases.player.PlayerViewModel
import com.example.miner_clicker.databases.storage.StorageItem
import com.example.miner_clicker.databases.storage.StorageViewModel
import com.example.miner_clicker.models.gameComponents.RandomMinerals


class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel,
                               private var mPlayerViewModel: PlayerViewModel,
                               private var mOreViewModel: OreViewModel):ViewModel() {
    private lateinit var ore : Ore
    private lateinit var storage : List<StorageItem>

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
    fun setStorage(storage : List<StorageItem>){
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
