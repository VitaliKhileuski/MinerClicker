package com.example.miner_clicker.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.models.Ore

class MainGameActionFragmentVM:ViewModel() {
    private var ore:Ore = Ore(10,5,1)
    private var money = MutableLiveData<Int>()
    public var Money : LiveData<Int> = money
    private var currentHpOre = MutableLiveData<Int>()
    public var CurrentHpOre: LiveData<Int> = currentHpOre
    private var maxHpOre = MutableLiveData<Int>()
    public var MaxHpOre : LiveData<Int> = maxHpOre

    init {
        money.value = 0
        maxHpOre.value =ore.maxHealth
        currentHpOre.value =ore.maxHealth
    }
    fun Click(){
        money.value=money.value!!.plus(1)
        currentHpOre.value = currentHpOre.value!!.minus(1)
        if(currentHpOre.value!! <= 0){
            ore.SetNewLevel()
            RefreshProperties()
        }
    }
    private fun RefreshProperties(){
        maxHpOre.value =ore.maxHealth
        currentHpOre.value =ore.maxHealth
    }
}