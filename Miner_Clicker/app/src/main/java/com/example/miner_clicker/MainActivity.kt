package com.example.miner_clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.miner_clicker.adapters.ViewPagerAdapter
import com.example.miner_clicker.fragments.ShopFragment
import com.example.miner_clicker.fragments.StorageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SetUpTabs()
    }



   private  fun SetUpTabs(){
        val adapter=ViewPagerAdapter(supportFragmentManager)
       adapter.addFragment(ShopFragment(),"Shop")
       adapter.addFragment(StorageFragment(),"storage")

    }
}