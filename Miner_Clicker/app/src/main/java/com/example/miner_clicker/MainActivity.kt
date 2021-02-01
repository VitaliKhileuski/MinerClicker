package com.example.miner_clicker
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.miner_clicker.adapters.ViewPagerAdapter
import com.example.miner_clicker.dataBase.DataBase
import com.example.miner_clicker.dataBase.tables.OreTable
import com.example.miner_clicker.dataBase.tables.PlayerTable
import com.example.miner_clicker.dataBase.tables.StorageTable
import com.example.miner_clicker.databinding.ActivityMainBinding
import com.example.miner_clicker.fragments.*
import com.example.miner_clicker.models.*
import com.example.miner_clicker.models.gameComponents.StorageItem
import com.example.miner_clicker.viewModels.MainActivityViewModel
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout
    var database: DataBase = DataBase(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this
        binding.viewModel= MainActivityViewModel()
        ConnectingWithDataBase()

        SetUpTabs()
        Set()

    }

    override fun onResume() {
        super.onResume()
        ConnectingWithDataBase()
    }



    private fun SetUpTabs(){
        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ShopFragment(),"Shop")
        adapter.addFragment(StorageFragment(database),"storage")
        adapter.addFragment(DrillFragment(), "Drill")
        adapter.addFragment(ExchangeFragment(), "Exchange")
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_shopping_cart_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_storage_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_construction_24)
        tabs.getTabAt(3)!!.setIcon(R.drawable.ic_baseline_account_balance_24)
    }

   private fun Set(){
       val adapter=ViewPagerAdapter(supportFragmentManager)
       adapter.addFragment(MainGameActionFragment(database))
       viewPager=findViewById(R.id.firstViewPager)
       viewPager.adapter=adapter

   }
    private fun ConnectingWithDataBase(){
        database.OpenDataBase()
        //database.DeleteAllRows(PlayerTable.TABLE_NAME)
                database.DeleteAllRows(OreTable.TABLE_NAME)
                //database.DeleteAllRows(StorageTable.TABLE_NAME)
                //database.InsertPlayerData(0,0)
        //database.InsertStorageData(StorageItem(Stone(),0,200))
        //database.InsertStorageData(StorageItem(Iron(),0,50))
        //database.InsertStorageData(StorageItem(Gold(),0,25))
        //database.InsertStorageData(StorageItem(Diamond(),0,10))
                database.InsertOreData(Ore(10,10,5,1))
    }

    override fun onDestroy() {
        super.onDestroy()
        database.CloseDataBase()
    }
}