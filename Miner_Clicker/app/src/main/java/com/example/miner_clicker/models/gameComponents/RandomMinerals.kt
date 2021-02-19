package com.example.miner_clicker.models.gameComponents


import com.example.miner_clicker.databases.storage.StorageItem

class RandomMinerals() {


        companion object {
            private val chancesForMinerals: MutableList<Int> = mutableListOf(70, 20, 8, 2)
            private var randNumber: Int = 0

            fun getStorageItems(storage : List<StorageItem>, capacity: Int) {
                val minerals: MutableList<Int> = RandMineral(capacity)
                for (i in 0..3) {
                    if(storage[i].numberOfMineral+minerals[i]>storage[i].Capacity){
                        storage[i].numberOfMineral = storage[i].Capacity
                    }
                    else {
                        storage[i].numberOfMineral += minerals[i]
                    }
                }

            }


            private fun RandMineral(Capacity: Int): MutableList<Int> {
                var _capacity: Int = Capacity
                val minerals: MutableList<Int> = mutableListOf(0, 0, 0, 0)
                val secondRange: Int = chancesForMinerals[0] + chancesForMinerals[1]
                val thirdRange: Int = secondRange + chancesForMinerals[2]
                while (_capacity > 0) {
                    randNumber = (1..100).shuffled().first()
                    when (randNumber) {
                        in 1..chancesForMinerals[0] -> minerals[0]++
                        in chancesForMinerals[0] + 1..secondRange -> minerals[1]++
                        in secondRange + 1..thirdRange -> minerals[2]++
                        in thirdRange + 1..100 -> minerals[3]++

                    }
                    _capacity -= 1

                }
                return minerals
            }

        }
    }