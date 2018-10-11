package com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.fragments

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gopi.architecture.sample.samplearchitectureapp.R
import android.widget.TextView
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.ChildPagerAdapter
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.NestedViewPagerActivity
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.PagerItem
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.ParentPagerAdapter
import kotlinx.android.synthetic.main.nested_pager_item.*


open class BaseFragment(var fragmentId: Int, var colorString: String, var text: String, var type:String) : Fragment() {
    /*constructor( fragmentId:Int, colorString: String, text: String):this() {

    }*/
    constructor() : this(0, "#ffffff", "","")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.pageritem, container, false)
        val pagerItemParent = view.findViewById(R.id.pager_item_parent) as ConstraintLayout
        val pagerItemText = view.findViewById(R.id.pager_item_text) as TextView
        pagerItemParent.setBackgroundColor(Color.parseColor(colorString))
        pagerItemText.text = text
        return view
    }
}

class NestedFragment(val fragmentManagerInstance: FragmentManager?, val activity: NestedViewPagerActivity?) : Fragment() {
    var currentSelectedItem: Int = 0

    constructor() : this(null, null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.nested_pager_item, container, false)
        val nestedViewPager = view.findViewById(R.id.nested_viewpager) as ViewPager
        nestedViewPager.setOffscreenPageLimit(3);
        nestedViewPager.adapter = ChildPagerAdapter(fragmentManager, mutableListOf(PagerItem(4, "#ff0000","nested"), PagerItem(5, "#0000ff","nested")), activity!!)
        nestedViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                currentSelectedItem = position
            }

        })
        return view
    }
}

class NestedChildFragment(var fragmentId: Int, var colorString: String, var text: String, var type:String, val activity: NestedViewPagerActivity?) : Fragment() {
    constructor() : this(0, "#ffffff", "","", null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.pageritem, container, false)
        val pagerItemParent = view.findViewById(R.id.pager_item_parent) as ConstraintLayout
        val pagerItemText = view.findViewById(R.id.pager_item_text) as TextView
        pagerItemParent.setBackgroundColor(Color.parseColor(colorString))
        pagerItemText.text = text.plus("sfdsfs")
        return view
    }

}
