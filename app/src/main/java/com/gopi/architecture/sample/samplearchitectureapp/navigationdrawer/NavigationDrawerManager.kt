package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer

import android.os.Build
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.helpers.NavigationDrawerUtils
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.repository.NavigationDrawerRepository
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.repository.NavigationItem

class NavigationDrawerManager {

    private lateinit var mNavigationItemList: MutableList<NavigationItem>
    private lateinit var mNavigationAdapter: NavigationAdapter
    private lateinit var mDrawerLayout: DrawerLayout
    private val mNavigationDrawerRepository: NavigationDrawerRepository
    private val mNavigationDrawerUtils: NavigationDrawerUtils

    init {
        mNavigationDrawerRepository = NavigationDrawerRepository
        mNavigationDrawerUtils = NavigationDrawerUtils
    }

    fun populateNavigationDrawer(activity: AppCompatActivity, navigationLayoutParent: View, recyclerView: RecyclerView, drawerLayout: DrawerLayout, name: String, hikeId: String) {
        val nameTv = navigationLayoutParent.findViewById<TextView>(R.id.nav_profile_name)
        val hikeIdTv = navigationLayoutParent.findViewById<TextView>(R.id.nav_profile_hikeid)
        val profileImageIv = navigationLayoutParent.findViewById<ImageView>(R.id.nav_profile_iv)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        mNavigationItemList = mNavigationDrawerRepository.getNavigationItemData()
        mNavigationAdapter = NavigationAdapter(mNavigationItemList) { item, position ->
            Toast.makeText(activity, "itemclicked of position $position", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = mNavigationAdapter
        this.mDrawerLayout = drawerLayout

        navigationLayoutParent.findViewById<ImageView>(R.id.nav_profile_camera).setOnClickListener { v -> Toast.makeText(activity, "camera clicked", Toast.LENGTH_SHORT).show() }
        navigationLayoutParent.findViewById<ImageView>(R.id.nav_profile_edit).setOnClickListener { v -> Toast.makeText(activity, "EDIT clicked", Toast.LENGTH_SHORT).show() }

        dofurtherUIProcessing(activity)
        hikeIdTv.setText(hikeId)
        nameTv.setText(name)
//        profileImageIv.setImageResource(R.color.nav_yellow)
    }

    private fun dofurtherUIProcessing(activity: AppCompatActivity) {
        mDrawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(p0: Int) {
            }

            override fun onDrawerSlide(p0: View, p1: Float) {
            }

            override fun onDrawerClosed(p0: View) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mNavigationDrawerUtils.setStatusBarTranslucent(false, activity.window)
                    //                    getWindow().setStatusBarColor(oldStatusBarColor)
                }
            }

            override fun onDrawerOpened(p0: View) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    /*if (oldStatusBarColor == -1) {
                        oldStatusBarColor = window.statusBarColor
                    }*/
                    //                    getWindow().setStatusBarColor(Color.TRANSPARENT)
                    mNavigationDrawerUtils.setStatusBarTranslucent(true, activity.window)
                }
            }

        })
    }

    fun toggleNavigationDrawerState(isOpen: Boolean) {
        if (isOpen) {
            this.mDrawerLayout.openDrawer(GravityCompat.END, true)
        } else {
            this.mDrawerLayout.closeDrawer(GravityCompat.END, true)
        }
    }

}

