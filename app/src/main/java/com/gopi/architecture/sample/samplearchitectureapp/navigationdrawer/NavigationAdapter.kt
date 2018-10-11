package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.inflate
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.setGone
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.setVisible

class NavigationAdapter(var navigationItemList: MutableList<NavigationItem>, val itemClickListener: (item: NavigationItem, position: Int) -> Unit) : RecyclerView.Adapter<NavigationViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, position: Int): NavigationViewHolder {
        return NavigationViewHolder(container.inflate(R.layout.navigation_item))
    }

    override fun getItemCount(): Int {
        return navigationItemList.size
    }

    override fun onBindViewHolder(viewHolder: NavigationViewHolder, position: Int) {
        val item = navigationItemList[position]
        viewHolder.navIv.setImageResource(item.iconDrawable)
        viewHolder.navIv.setBackgroundColor(viewHolder.itemView.context.resources.getColor(item.backgroundColor))
        viewHolder.navTitle.setText(item.title)
        /*if(item.counter)*/
        viewHolder.navCounter.setGone()
        item.counter?.apply {
            viewHolder.navCounter.setVisible()
            viewHolder.navCounter.setText(item.counter.toString())
        }
    }
}

class NavigationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val navIv: ImageView
    val navTitle: TextView
    val navCounter: TextView

    init {
        navIv = view.findViewById(R.id.nav_item_iv)
        navTitle = view.findViewById(R.id.nav_item_title)
        navCounter = view.findViewById(R.id.nav_item_counter)
    }

}