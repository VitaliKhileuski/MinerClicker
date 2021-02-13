package com.example.miner_clicker
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.miner_clicker.adapters.ViewPagerAdapter
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerViewModel
import com.example.miner_clicker.data2.storage.Storage
import com.example.miner_clicker.data2.storage.StorageViewModel
import com.example.miner_clicker.databinding.ActivityMainBinding
import com.example.miner_clicker.fragments.*
import com.example.miner_clicker.models.*
import com.example.miner_clicker.viewModels.MainActivityViewModel
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout
    private lateinit var mStorageViewModel : StorageViewModel
    private lateinit var mPlayerViewModel : PlayerViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = MainActivityViewModel()
        mStorageViewModel = ViewModelProvider(this).get(StorageViewModel::class.java)
        mPlayerViewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        SetUpTabs()
        Set()

    }

    override fun onResume() {
        super.onResume()

    }



    private fun SetUpTabs(){
        val adapter=ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ShopFragment(),"Shop")
        adapter.addFragment(StorageFragment(mStorageViewModel),"storage")
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
       adapter.addFragment(MainGameActionFragment(mStorageViewModel, mPlayerViewModel))
       viewPager=findViewById(R.id.firstViewPager)
       viewPager.adapter=adapter

   }


    override fun onDestroy() {
        super.onDestroy()
    }
}