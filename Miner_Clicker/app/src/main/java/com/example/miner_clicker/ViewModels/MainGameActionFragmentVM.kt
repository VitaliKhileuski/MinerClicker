package com.example.miner_clicker.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainGameActionFragmentVM:ViewModel() {

    private var money= MutableLiveData<Int>()
    public var Money: LiveData<Int> = money
    private var currentHpOre = MutableLiveData<Int>()
    public var CurrentHpOre: LiveData<Int> = currentHpOre
    private var maxHpOre = MutableLiveData<Int>()
    public var MaxHpOre : LiveData<Int> = maxHpOre

    init {
        money.value = 0
        maxHpOre.value = 10000
        currentHpOre.value = maxHpOre.value
    }
    fun Click(){
        money.value=money.value!!.plus(1)
        currentHpOre.value = currentHpOre.value!!.minus(1000)
        if(currentHpOre.value!! <= 0){
            maxHpOre.value = maxHpOre.value!!.plus(5000)
            currentHpOre.value = maxHpOre.value
        }
    }
}