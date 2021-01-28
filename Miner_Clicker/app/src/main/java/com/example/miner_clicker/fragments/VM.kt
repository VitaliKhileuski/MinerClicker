package com.example.miner_clicker.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VM:ViewModel() {
    private var money= MutableLiveData<Int>()
    public var Money: LiveData<Int> = money
    init {
        money.value = 0
    }
    fun Click(){
        money.value=money.value!!.plus(1)
    }
}