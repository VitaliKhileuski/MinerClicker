package com.example.miner_clicker.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.R
import com.example.miner_clicker.adapters.ConvertBigNumbers
import com.example.miner_clicker.adapters.StorageRecyclerAdapter
import com.example.miner_clicker.data2.StorageViewModel
import com.example.miner_clicker.fragments.StorageFragment
import com.example.miner_clicker.models.Ore
import com.example.miner_clicker.models.Pickaxe
import com.example.miner_clicker.models.gameComponents.Player
import com.example.miner_clicker.models.gameComponents.RandomMinerals
import com.example.miner_clicker.models.gameComponents.Storage

<<<<<<< HEAD
class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel):ViewModel() {
    //private var player : Player = database.ReadPlayerData()
    //private var ore : Ore = database.ReadPOreData()
    //private var storage : Storage = database.ReadStorageData()

=======
class MainGameActionFragmentVM(var database: DataBase, var storageFragment: StorageFragment) : ViewModel() {
    private var player: Player = database.ReadPlayerData()
    private var ore: Ore = database.ReadPOreData()
    private var storage: Storage = database.ReadStorageData()
>>>>>>> 820f35bcbbaab7c57f0cc76146e0bf3b412ceb37
    private var money = MutableLiveData<Int>()
    private var stringMoney = MutableLiveData<String>()
    private var gems = MutableLiveData<Int>()
    private var capacity = MutableLiveData<Int>()
    private var level = MutableLiveData<Int>()
    private var maxHpOre = MutableLiveData<Int>()
    private var currentHpOre = MutableLiveData<Int>()
    private var textProgressBar = MutableLiveData<String>()

    public var TextProgressBar: LiveData<String> = textProgressBar
    public var Money: LiveData<Int> = money
    public var CurrentHpOre: LiveData<Int> = currentHpOre
    public var MaxHpOre: LiveData<Int> = maxHpOre
    public var Gems: LiveData<Int> = gems
    public var Capacity: LiveData<Int> = capacity
    public var Level: LiveData<Int> = level
    public var flag: Boolean = false
    public var StringMoney: LiveData<String> = stringMoney

    init {
<<<<<<< HEAD

        //money.value = player.money
        //if(money.value!!>=1000){
          //  stringMoney.value =ConvertBigNumbers.ToString(money.value!!)
        //}else{
       // stringMoney.value = money.value.toString()
        }


        //gems.value = player.gems
        //RefreshProperties()
fun NewClick(){
    mStorageViewModel.deleteById(1)
}


}
    fun Click(){

        //money.value=money.value!!.plus(1)
        //stringMoney.value=money.value.toString()
        //if(money.value!!>=1000){
           //stringMoney.value=ConvertBigNumbers.ToString(money.value!!)
        }

        //currentHpOre.value = currentHpOre.value!!.minus(player.currentPickaxe.damage)
        //ore.currenthealth = currentHpOre.value!!
        //database.UpdateOreCurrentHealth(ore.currenthealth)
        //textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
        //if(currentHpOre.value!! <= 0){
          //  createNewOre()
           // UpdateStorageRecyclerView()
        //}
    //}
    private fun RefreshProperties(){
        //maxHpOre.value =ore.maxHealth
        //currentHpOre.value =ore.currenthealth
        //capacity.value=ore.capacity
        //textProgressBar.value=currentHpOre.value.toString()+"/"+maxHpOre.value.toString()
    }
    fun createNewOre(){

        //RandomMinerals.getStorageItems(storage,ore.capacity)

        //ore.SetNewLevel()
        //UpdateDatabase()
        RefreshProperties()

    }
    private fun UpdateDatabase(){
        //database.UpdateStorage(storage)
        //database.UpdateMoney(money.value!!)
        //database.UpdateOre(ore)
    }

    private fun UpdateStorageRecyclerView(){
        //var test = storageFragment.view?.findViewById<RecyclerView>(R.id.storage_recyclerView)
        //test?.adapter = StorageRecyclerAdapter(database.ReadStorageData().storageItems)
    }

=======
        money.value = player.money
        if (money.value!! >= 1000) {
            stringMoney.value = ConvertBigNumbers.ToString(money.value!!)
        } else {
            stringMoney.value = money.value.toString()
        }
        gems.value = player.gems
        RefreshProperties()
    }

    fun Click() {
        money.value = money.value!!.plus(1)
        stringMoney.value = money.value.toString()
        if (money.value!! >= 1000) {
            stringMoney.value = ConvertBigNumbers.ToString(money.value!!)
        }
        currentHpOre.value = currentHpOre.value!!.minus(player.currentPickaxe.damage)
        ore.currenthealth = currentHpOre.value!!
        database.UpdateOreCurrentHealth(ore.currenthealth)
        textProgressBar.value = currentHpOre.value.toString() + "/" + maxHpOre.value.toString()
        if (currentHpOre.value!! <= 0) {
            createNewOre()
            UpdateStorageRecyclerView()
        }
    }

    private fun RefreshProperties() {
        maxHpOre.value = ore.maxHealth
        currentHpOre.value = ore.currenthealth
        capacity.value = ore.capacity
        textProgressBar.value = currentHpOre.value.toString() + "/" + maxHpOre.value.toString()
    }

    fun createNewOre() {
        RandomMinerals.getStorageItems(storage, ore.capacity)
        ore.SetNewLevel()
        UpdateDatabase()
        RefreshProperties()

    }

    private fun UpdateDatabase() {
        database.UpdateStorage(storage)
        database.UpdateMoney(money.value!!)
        database.UpdateOre(ore)
    }

    private fun UpdateStorageRecyclerView() {
        var test = storageFragment.view?.findViewById<RecyclerView>(R.id.storage_recyclerView)
        test?.adapter = StorageRecyclerAdapter(database.ReadStorageData().storageItems)
    }

    fun updateMoneyAfterBuying(pickaxe: Pickaxe) {
        if(pickaxe.price <= money.value!!){
            money.value = money.value!!.minus(pickaxe.price)
            if (money.value!! >= 1000) {
                stringMoney.value = ConvertBigNumbers.ToString(money.value!!)
            } else {
                stringMoney.value = money.value.toString()
            }
            database.UpdateMoney(money.value!!)
            player = database.ReadPlayerData()
            database.DeleteAllRows("Pickaxe")
            database.InsertPickaxeData(pickaxe)
        }
    }
}
>>>>>>> 820f35bcbbaab7c57f0cc76146e0bf3b412ceb37
