package com.gopi.architecture.sample.samplearchitectureapp.parallaxAnimation

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide.init
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.inflate

class ParallaxAnimationAdapter(var itemList: MutableList<ParallaxItem>, val itemClickListener: (item: ParallaxItem, position: Int) -> Unit) : RecyclerView.Adapter<ParallaxAnimationViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, position: Int): ParallaxAnimationViewHolder {
        if (getItemViewType(position) == 0) return ParallaxAnimationViewHolder(container.inflate(R.layout.parallax_item))
        return ParallaxAnimationViewHolder(container.inflate(R.layout.parallax_item))
    }

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int) = 0

    override fun onBindViewHolder(viewHolder: ParallaxAnimationViewHolder, position: Int) {
        val item = itemList[position]
        viewHolder.itemView.setOnClickListener { itemClickListener(item, position) }
        viewHolder.title.text = item.name
    }
}

class ParallaxAnimationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.parallax_title)

}

data class ParallaxItem(var name: String = "Parallax")

