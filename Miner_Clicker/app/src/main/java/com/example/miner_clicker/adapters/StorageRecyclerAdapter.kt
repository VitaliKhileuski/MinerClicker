package com.example.miner_clicker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.R
import com.example.miner_clicker.data2.storage.Storage

class StorageRecyclerAdapter() : RecyclerView.Adapter<StorageRecyclerAdapter.ViewHolder>() {

    private var storageItems: List<Storage> = emptyList<Storage>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resourceName: TextView = itemView.findViewById(R.id.resource_name)
        val resourceAmount: TextView = itemView.findViewById(R.id.resource_amount)
        val resourceCapacity: TextView = itemView.findViewById(R.id.resource_max_capacity)
        //val resourceImage: ImageView = itemView.findViewById(R.id.resource_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.storage_view_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.resourceName.text = storageItems[position].mineral
        holder.resourceAmount.text = storageItems[position].numberOfMineral.toString()
        holder.resourceCapacity.text = storageItems[position].Capacity.toString()
        // holder.resourceImage.setImageResource(storageItems[position].mineral.iconSource)
    }

    override fun getItemCount(): Int {
        return storageItems.count()
    }

    public fun setData(storage: List<Storage>) {
        this.storageItems = storage
        notifyDataSetChanged()
    }
}