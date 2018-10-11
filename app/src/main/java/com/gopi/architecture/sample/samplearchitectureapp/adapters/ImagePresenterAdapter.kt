package com.gopi.architecture.sample.samplearchitectureapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageData
import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageDataNetwork

class ImagePresenterAdapter() : RecyclerView.Adapter<ViewHolder>() {

    var imageDataCompleteList: MutableList<ImageData> = mutableListOf()


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.image_viewing_item, viewGroup, false))
    }


    override fun getItemCount(): Int {
        return imageDataCompleteList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = imageDataCompleteList.get(position)
        if (item.type == "network") {
            val itemNetwork = item as ImageDataNetwork
            Glide.with(viewHolder.imageView.context).load(itemNetwork.networkUrl).into(viewHolder.imageView)
        }
    }

    fun addItems(list: MutableList<ImageData>){
        val previousSize = imageDataCompleteList.size
        imageDataCompleteList.addAll(list)
        notifyItemRangeInserted(previousSize, list.size)
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView

    init {
        imageView = itemView.findViewById<ImageView>(R.id.imageview_iv)
    }
}