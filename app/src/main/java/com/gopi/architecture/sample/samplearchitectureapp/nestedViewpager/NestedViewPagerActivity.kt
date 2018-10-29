package com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.NavigationDrawerActivity

class NestedViewPagerActivity : AppCompatActivity() {
    lateinit var parentViewPager: DisableableViewPager
    var currentSelectedItem: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_view_pager)

        parentViewPager = findViewById<DisableableViewPager>(R.id.parent_view_pager)
        findViewById<Button>(R.id.sample_button).setOnClickListener{ startActivity(Intent(this,NavigationDrawerActivity::class.java )) }
        parentViewPager.setOffscreenPageLimit(3);
        val parentPagerAdapter = ParentPagerAdapter(supportFragmentManager, mutableListOf(PagerItem(0, "#ff0000"), PagerItem(1, "#00ff00"), PagerItem(2, "#0000ff")), this)
        parentViewPager.adapter = parentPagerAdapter
//        parentViewPager.addOnPageChangeListener( ViewPagerOnPageScrolled())

        parentViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                currentSelectedItem = position
                /*if (position == 0 && parentPagerAdapter.nestedFragment.currentSelectedItem == 0) {
                    parentViewPager.disableScroll()
                } else {
                    parentViewPager.enableScroll()
                }*/

            }

        })

    }

 /*   inner class ViewPagerOnPageScrolled(private val pageScrolled: (Int, Float, Int) -> Unit = { _, _, _ -> }) : ViewPager.OnPageChangeListener {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            pageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
//        this@ViewPagerOnPageScrolled.currentSelectedItem = position
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }*/
}
