package com.example.miner_clicker.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerViewModel
import com.example.miner_clicker.data2.storage.StorageViewModel
import kotlin.math.absoluteValue


class MainGameActionFragmentVM(private var mStorageViewModel: StorageViewModel,
                               private var mPlayerViewModel: PlayerViewModel):ViewModel() {

    private var number : Int =0
    lateinit  var players :  LiveData<List<Player>>

init{
   players = mPlayerViewModel.readAllData
    number= players.value!!.size
   }

fun click(){
   // player.money+=1
    //mPlayerViewModel.updatePlayer(player)
}


}

