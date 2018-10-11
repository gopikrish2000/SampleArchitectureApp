package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.gopi.architecture.sample.samplearchitectureapp.R
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import android.view.WindowManager


class NavigationDrawerActivity : AppCompatActivity() {
    var mDrawerToggle: ActionBarDrawerToggle? = null
    private lateinit var mDrawerLayout: DrawerLayout
    var oldStatusBarColor: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
//        someTextTv.text = "wirewrwiuo"
//        someTextTv.setOnClickListener { _ -> drawerLayout.openDrawer(drawerLayout, true) }
//        drawerLayout.openDrawer(4)
//        setupDrawerToggle()
//        drawerLayout.openDrawer(drawerLayout)

        mDrawerLayout = findViewById(R.id.drawerLayout) as DrawerLayout

//        val navigationView: android.support.design.widget.NavigationView = findViewById(R.id.nav_view)
        val navigationView: View = findViewById(R.id.nav_view)
        /*navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }*/
        someTv.setOnClickListener { v -> mDrawerLayout.closeDrawers() }

        third_item.setOnClickListener { v -> mDrawerLayout.openDrawer(GravityCompat.END, true) }
        mDrawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
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

        })
    }

    fun setStatusBarTranslucent(makeTranslucent: Boolean) {
        if (makeTranslucent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false)
//            window.statusBarColor = Color.TRANSPARENT
            /*getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            );*/
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }


    fun setupDrawerToggle() {
        mDrawerToggle = android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, null, R.string.app_name, R.string.app_name)
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle?.syncState()
    }
}
