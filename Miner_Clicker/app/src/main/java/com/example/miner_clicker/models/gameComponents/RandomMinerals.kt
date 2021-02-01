package com.example.miner_clicker.models.gameComponents

import com.example.miner_clicker.dataBase.DataBase
import com.example.miner_clicker.models.Diamond
import com.example.miner_clicker.models.Gold
import com.example.miner_clicker.models.Iron
import com.example.miner_clicker.models.Stone

    class RandomMinerals(Capacity:Int?)
{




    var randNumber : Int = 0
    val storageItems : MutableList<StorageItem> = mutableListOf(
            StorageItem(Stone(),0,0),
            StorageItem(Iron(),0,0),
            StorageItem(Gold(),0,0),
            StorageItem(Diamond(),0,0)

    )
    val storage : Storage = Storage(storageItems)

    companion object {
        val chancesForMinerals: MutableList<Int> = mutableListOf(70, 20, 8, 2)
        var randNumber : Int = 0

        fun getStorageItems(storage: Storage,capacity : Int) {
            var minerals: MutableList<Int> = RandMineral(capacity)
            for (i in 0..3) {
                storage.storageItems[i].numberOfMineral += minerals[i]
            }

        }


        fun RandMineral(Capacity: Int): MutableList<Int> {
            var capacity : Int? = Capacity
            var minerals: MutableList<Int> = mutableListOf(0, 0, 0, 0)
            var secondRange: Int = chancesForMinerals[0] + chancesForMinerals[1]
            var thirdRange: Int = secondRange + chancesForMinerals[2]
            while (capacity!! >= 0)
                randNumber = (1..100).shuffled().first()
            when (randNumber) {
                in 1..chancesForMinerals[0] -> minerals[0]++
                in chancesForMinerals[0] + 1..secondRange -> minerals[1]++
                in secondRange + 1..thirdRange -> minerals[2]++
                in thirdRange + 1..100 -> minerals[3]++

            }
            capacity.minus(1)
            return minerals
        }
    }

}