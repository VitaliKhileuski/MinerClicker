package com.example.miner_clicker.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.dataBase.DataBase
import com.example.miner_clicker.models.Ore
import com.example.miner_clicker.models.gameComponents.Player
import com.example.miner_clicker.models.gameComponents.RandomMinerals
import com.example.miner_clicker.models.gameComponents.Storage

class MainGameActionFragmentVM(var database : DataBase):ViewModel() {
    private var ore : Ore = database.ReadPOreData()
    private var money = MutableLiveData<Int>()
    private var capacity = MutableLiveData<Int>()
    private var level = MutableLiveData<Int>()
    private var textProgressBar = MutableLiveData<String>()
    private var gems = MutableLiveData<Int>()
    public var TextProgressBar : LiveData<String> = textProgressBar
    public var Money : LiveData<Int> = money
    private var currentHpOre = MutableLiveData<Int>()
    public var CurrentHpOre: LiveData<Int> = currentHpOre
    private var maxHpOre = MutableLiveData<Int>()
    public var MaxHpOre : LiveData<Int> = maxHpOre
    public var Gems : LiveData<Int> = gems
    public var Capacity : LiveData<Int> = capacity
    public var Level : LiveData<Int> = level
    public var player : Player = database.ReadPlayerData()


    init {
        money.value = player.money
        gems.value = player.gems
        RefreshProperties()
    }
    fun Click(){
        money.value=money.value!!.plus(1)
        database.UpdateMoney(money.value!!)
        currentHpOre.value = currentHpOre.value!!.minus(1)
        ore.currenthealth--
        database.UpdateOreCurrentHealth(ore.currenthealth)
        textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
        if(currentHpOre.value!! <= 0){
            createNewOre()
        }
    }
    private fun RefreshProperties(){
        maxHpOre.value =ore.maxHealth
        currentHpOre.value =ore.maxHealth
        capacity.value=ore.capacity
        textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
    }
    fun createNewOre(){
        //var random : RandomMinerals = RandomMinerals(capacity.value)
            //    var storage : Storage = random.getStorageItems()  // FIXME: 31.01.2021
        ore.SetNewLevel()
        database.UpdateOre(ore)
        RefreshProperties()

    }
}
