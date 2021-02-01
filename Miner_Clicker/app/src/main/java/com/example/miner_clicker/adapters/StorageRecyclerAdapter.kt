package com.example.miner_clicker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.R
import com.example.miner_clicker.models.gameComponents.StorageItem

class StorageRecyclerAdapter(private var storageItems: List<StorageItem>) : RecyclerView.Adapter<StorageRecyclerAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val resourceName: TextView = itemView.findViewById(R.id.resource_name)
        val resourceAmount: TextView = itemView.findViewById(R.id.resource_amount)
        val resourceImage: ImageView = itemView.findViewById(R.id.resource_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.storage_view_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.resourceName.text = storageItems[position].mineral.name
        holder.resourceAmount.text =storageItems[position].numberOfMineral.toString()
        holder.resourceImage.setImageResource(storageItems[position].mineral.iconSource)
    }

    override fun getItemCount(): Int {
        return storageItems.count()
    }

}