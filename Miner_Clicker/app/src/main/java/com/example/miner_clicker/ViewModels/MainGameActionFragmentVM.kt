package com.example.miner_clicker.viewModels



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.R
import com.example.miner_clicker.adapters.ConvertBigNumbers
import com.example.miner_clicker.dataBase.DataBase
import com.example.miner_clicker.models.Ore
import com.example.miner_clicker.models.gameComponents.Player
import com.example.miner_clicker.models.gameComponents.RandomMinerals
import com.example.miner_clicker.models.gameComponents.Storage

class MainGameActionFragmentVM(var database : DataBase):ViewModel() {
    private var player : Player = database.ReadPlayerData()
    private var ore : Ore = database.ReadPOreData()
    private var storage : Storage = database.ReadStorageData()

    private var money = MutableLiveData<Int>()
    private var gems = MutableLiveData<Int>()

    private var capacity = MutableLiveData<Int>()
    private var level = MutableLiveData<Int>()
    private var maxHpOre = MutableLiveData<Int>()
    private var currentHpOre = MutableLiveData<Int>()

    private var textProgressBar = MutableLiveData<String>()

    public var TextProgressBar : LiveData<String> = textProgressBar
    public var Money : LiveData<Int> = money
    public var CurrentHpOre: LiveData<Int> = currentHpOre
    public var MaxHpOre : LiveData<Int> = maxHpOre
    public var Gems : LiveData<Int> = gems
    public var Capacity : LiveData<Int> = capacity
    public var Level : LiveData<Int> = level

    public var flag : Boolean = false
    private var stringMoney = MutableLiveData<String>()
    public var StringMoney : LiveData<String> = stringMoney


    init {
        money.value = player.money
        if(money.value!!>=1000)
        stringMoney.value =ConvertBigNumbers.ToString(money.value!!)
        gems.value = player.gems
        RefreshProperties()
    }
    fun Click(){
        money.value=money.value!!.plus(1)
        stringMoney.value=money.value.toString()
        if(money.value!!>=1000){
           stringMoney.value=ConvertBigNumbers.ToString(money.value!!)
        }

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
        currentHpOre.value =ore.currenthealth
        capacity.value=ore.capacity
        textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
    }
    fun createNewOre(){

        RandomMinerals.getStorageItems(storage,ore.capacity)
        UpdateDatabase()
        ore.SetNewLevel()
        RefreshProperties()

    }
    private fun UpdateDatabase(){
        database.UpdateStorage(storage)
        database.UpdateMoney(money.value!!)
        database.UpdateOre(ore)
    }
}
