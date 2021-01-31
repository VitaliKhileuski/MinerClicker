package com.example.miner_clicker.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.models.Ore
import com.example.miner_clicker.models.gameComponents.RandomMinerals
import com.example.miner_clicker.models.gameComponents.Storage

class MainGameActionFragmentVM:ViewModel() {
    private var ore:Ore = Ore(10,5,1)
    private var money = MutableLiveData<Int>()
    private var capacity = MutableLiveData<Int>()
    private var textProgressBar = MutableLiveData<String>()
    public var TextProgressBar : LiveData<String> = textProgressBar
    public var Money : LiveData<Int> = money
    private var currentHpOre = MutableLiveData<Int>()
    public var CurrentHpOre: LiveData<Int> = currentHpOre
    private var maxHpOre = MutableLiveData<Int>()
    public var MaxHpOre : LiveData<Int> = maxHpOre
    public var Capacity : LiveData<Int> = capacity


    init {
        money.value = 0
        RefreshProperties()
    }
    fun Click(){
        money.value=money.value!!.plus(1)
        currentHpOre.value = currentHpOre.value!!.minus(1)
        textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
        if(currentHpOre.value!! <= 0){
            createNewOre()
        }
    }
    private fun RefreshProperties(){
        maxHpOre.value =ore.maxHealth
        currentHpOre.value =ore.maxHealth
        textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
    }
    fun createNewOre(){
        var random : RandomMinerals = RandomMinerals(capacity.value)
            //    var storage : Storage = random.getStorageItems()  // FIXME: 31.01.2021
        ore.SetNewLevel()
        RefreshProperties()

    }
}
