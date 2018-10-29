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
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.putStringInfo
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.ChildPagerAdapter
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.NestedViewPagerActivity
import com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager.PagerItem


open class BaseFragment() : Fragment() {
    /*constructor( fragmentId:Int, colorString: String, text: String):this() {

    }*/
//    constructor() : this(0, "#ffffff", "", "")

    companion object {
        fun newInstance(fragmentId: Int, colorString: String, text: String, type: String): BaseFragment {
            val fragment = BaseFragment()
            fragment.arguments = Bundle().apply { putStringInfo("colorStr", colorString).putStringInfo("text", text) }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val colorString = arguments?.getString("colorStr", "#ffffff")
        val text = arguments?.getString("text", "DEFAULT_TEXT")

        val view = inflater.inflate(R.layout.pageritem, container, false)
        val pagerItemParent = view.findViewById(R.id.pager_item_parent) as ConstraintLayout
        val pagerItemText = view.findViewById(R.id.pager_item_text) as TextView
        pagerItemParent.setBackgroundColor(Color.parseColor(colorString))
        pagerItemText.text = text
        return view
    }
}

class NestedFragment() : Fragment() {
    var currentSelectedItem: Int = 0

//    constructor() : this(null, null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val fragmentManagerInstance: FragmentManager?, val activity: NestedViewPagerActivity?
        val view = inflater.inflate(R.layout.nested_pager_item, container, false)
        val nestedViewPager = view.findViewById(R.id.nested_viewpager) as ViewPager
        nestedViewPager.offscreenPageLimit = 3;
        nestedViewPager.adapter = ChildPagerAdapter(fragmentManager, mutableListOf(PagerItem(4, "#ff0000", "nested"), PagerItem(5, "#0000ff", "nested")), (activity as? NestedViewPagerActivity))
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

class NestedChildFragment() : Fragment() {

    companion object {
        fun newInstance(fragmentId: Int, colorString: String, text: String, type: String, activity: NestedViewPagerActivity?): NestedChildFragment {
            val nestedChildFragment = NestedChildFragment()
            nestedChildFragment.arguments = Bundle().apply { putStringInfo("colorStr", colorString).putStringInfo("text", text) }
            return nestedChildFragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val colorString = arguments?.getString("colorStr", "#ffffff")
        val text = arguments?.getString("text", "DEFAULT_TEXT")

        val view = inflater.inflate(R.layout.pageritem, container, false)
        val pagerItemParent = view.findViewById(R.id.pager_item_parent) as ConstraintLayout
        val pagerItemText = view.findViewById(R.id.pager_item_text) as TextView
        pagerItemParent.setBackgroundColor(Color.parseColor(colorString))
        pagerItemText.text = text.plus("sfdsfs")
        return view
    }

}
