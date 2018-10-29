package com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.fragments.BaseFragment
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.fragments.NestedChildFragment
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.fragments.NestedFragment

class ParentPagerAdapter(val fm: FragmentManager?, var itemList: MutableList<PagerItem>, val activity: NestedViewPagerActivity) : FragmentPagerAdapter(fm) {
//    val nestedFragment: NestedFragment

    init {
//        nestedFragment = NestedFragment(fm, activity)
    }

    override fun getItem(position: Int): Fragment {
        val item = itemList[position]
        return when (position) {
            0 -> NestedFragment()
            else -> BaseFragment.newInstance(item.id, item.colorString, item.id.toString(), item.type)
        }
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.d("GOPIPAGERPARENT", "instantiateItem of container position $position")
        return super.instantiateItem(container, position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d("GOPIPAGERPARENT", "DESTROY item of container position $position")
        super.destroyItem(container, position, `object`)
    }
}

class ChildPagerAdapter(val fm: FragmentManager?, var itemList: MutableList<PagerItem>, val activityInstance: NestedViewPagerActivity?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val item = itemList[position]
        return when (position) {
            else -> NestedChildFragment.newInstance(item.id, item.colorString, item.id.toString(), item.type, activityInstance)
        }
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.d("GOPIPAGERCHILD", "instantiateItem of container position $position")
        return super.instantiateItem(container, position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d("GOPIPAGERCHILD", "DESTROY item of container position $position")
        super.destroyItem(container, position, `object`)
    }
}

data class PagerItem(var id: Int, val colorString: String) {
    var type: String = "default"

    constructor(id: Int, colorString: String, type: String) : this(id, colorString) {
        this.type = type
    }
}