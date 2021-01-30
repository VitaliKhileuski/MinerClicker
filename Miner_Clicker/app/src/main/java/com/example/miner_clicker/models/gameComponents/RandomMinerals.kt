package com.example.miner_clicker.models.gameComponents

class RandomMinerals(Capacity:Int?)
{
    val chancesForMinerals: MutableList<Int> = mutableListOf(70, 20, 8, 2)

    var capacity : Int? = Capacity
    var randNumber : Int = 0
    var storage : Storage = Storage()
    fun getStorageItems() : Storage{
        var minerals: MutableList<Int> = RandMineral()
        for(i in 0..3) {
            storage.storageItems[i].numberOfMineral = minerals[i]
        }

        return storage
    }



    fun RandMineral() :MutableList<Int>{
        var minerals : MutableList<Int> = mutableListOf(0,0,0,0)
        var secondRange : Int = chancesForMinerals[0]+chancesForMinerals[1]
        var thirdRange : Int = secondRange+chancesForMinerals[2]
        while(capacity!!>=0)
        randNumber = (1..100).shuffled().first()
        when(randNumber){
            in 1..chancesForMinerals[0] -> minerals[0]++
            in chancesForMinerals[0]+1..secondRange -> minerals[1]++
            in secondRange+1..thirdRange -> minerals[2]++
            in thirdRange+1..100 -> minerals[3]++

        }
        capacity!!.minus(1)
        return minerals
    }

}