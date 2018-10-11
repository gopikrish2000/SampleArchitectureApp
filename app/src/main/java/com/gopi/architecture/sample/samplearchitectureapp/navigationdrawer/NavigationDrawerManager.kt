package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer

import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import com.gopi.architecture.sample.samplearchitectureapp.R

class NavigationDrawerManager {

    private var mNavigationItemList: MutableList<NavigationItem>
    private var mNavigationAdapter: NavigationAdapter
    private lateinit var mDrawerLayout: DrawerLayout

    init {
        mNavigationItemList = mutableListOf(
                NavigationItem(R.drawable.ic_action_achievement, R.color.nav_blue_light, R.string.nav_bar_posts, null, "Default"),
                NavigationItem(R.drawable.ic_action_achievement, R.color.nav_blue_light, R.string.nav_bar_posts, null, "Default"),
                NavigationItem(R.drawable.ic_action_achievement, R.color.nav_blue_light, R.string.nav_bar_posts, 5, "Counter"),
                NavigationItem(R.drawable.ic_action_achievement, R.color.nav_blue_light, R.string.nav_bar_posts, null, "Default"),
                NavigationItem(R.drawable.ic_action_achievement, R.color.nav_blue_light, R.string.nav_bar_posts, null, "Default")
        )
        mNavigationAdapter = NavigationAdapter(mNavigationItemList) { item, position ->
            //            Toast.makeText(Appli)
        }
    }

    fun initUIBindings(recyclerView: RecyclerView, drawerLayout: DrawerLayout) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = mNavigationAdapter
        this.mDrawerLayout = drawerLayout

        /*mDrawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(p0: Int) {
            }

            override fun onDrawerSlide(p0: View, p1: Float) {
            }

            override fun onDrawerClosed(p0: View) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setStatusBarTranslucent(false)
//                    getWindow().setStatusBarColor(oldStatusBarColor)
                };
            }

            override fun onDrawerOpened(p0: View) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (oldStatusBarColor == -1) {
                        oldStatusBarColor = window.statusBarColor
                    }
//                    getWindow().setStatusBarColor(Color.TRANSPARENT)
                    setStatusBarTranslucent(true)
                };
            }

        })*/
    }

    fun toggleNavigationDrawerState(isOpen: Boolean) {
        if (isOpen) {
            this.mDrawerLayout.openDrawer(GravityCompat.END, true)
        } else {
            this.mDrawerLayout.closeDrawer(GravityCompat.END, true)
        }
    }

    /* fun setStatusBarTranslucent(makeTranslucent: Boolean) {
         if (makeTranslucent) {
             window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
             //setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false)
 //            window.statusBarColor = Color.TRANSPARENT
             *//*getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            );*//*
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }*/
}

open class NavigationItem(@DrawableRes val iconDrawable: Int, @ColorRes val backgroundColor: Int, @StringRes val title: Int, var counter: Int?, val itemType: String)

//data class NavigationItemNofication () : NavigationItem()