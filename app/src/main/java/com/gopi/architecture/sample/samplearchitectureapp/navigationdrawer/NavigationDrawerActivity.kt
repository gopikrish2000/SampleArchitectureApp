package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer

import android.os.Build
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.gopi.architecture.sample.samplearchitectureapp.R
import kotlinx.android.synthetic.main.activity_navigation_drawer.*


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
//        someTv.setOnClickListener { v -> mDrawerLayout.closeDrawers() }

        val navigationDrawerManager = NavigationDrawerManager()
        third_item.setOnClickListener { v -> navigationDrawerManager.toggleNavigationDrawerState(true) }


        navigationDrawerManager.initUIBindings(findViewById(R.id.hike_nav_recyclerview), mDrawerLayout)
    }




    fun setupDrawerToggle() {
        mDrawerToggle = android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, null, R.string.app_name, R.string.app_name)
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle?.syncState()
    }
}
