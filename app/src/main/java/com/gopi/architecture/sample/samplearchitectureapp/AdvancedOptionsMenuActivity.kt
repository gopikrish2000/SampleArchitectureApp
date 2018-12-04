package com.gopi.architecture.sample.samplearchitectureapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_advanced_options_menu.*

class AdvancedOptionsMenuActivity : AppCompatActivity() {
    var menuParent: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_options_menu)
        changeMenuOptionBtn.setOnClickListener {
            menuParent?.removeItem(R.id.navigation_dashboard)
            menuInflater?.inflate(R.menu.menu_other, menuParent) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuParent = menu
        menuInflater.inflate(R.menu.menu_multiple, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
