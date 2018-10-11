package com.gopi.architecture.sample.samplearchitectureapp.fabPractise

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.Toast
import com.github.clans.fab.FloatingActionMenu
import com.gopi.architecture.sample.samplearchitectureapp.R

class FabActivity : AppCompatActivity() {
    var state:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        val changeFabIcon = findViewById<Button>(R.id.changedFabIcon)
        val fab = findViewById<FloatingActionMenu>(R.id.fab)
        val uiHandler = Handler(Looper.getMainLooper())

        /*fab.setOnClickListener { view ->
            *//*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            Toast.makeText(this, "Replace with Change fab", Toast.LENGTH_SHORT).show()
            uiHandler.postDelayed({ fab.menuIconView.setImageResource(R.drawable.ic_action_ball) }, 4000)*//*
        }*/
        changeFabIcon.setOnClickListener { v ->
//            fab.hideMenuButton(true)
//            uiHandler.postDelayed({ fab.menuIconView.setImageResource(R.drawable.ic_action_ball); fab.showMenuButton(true)}, 3000)
            state = 1
//            fab.hideMenu()
//            fab.addMenuButton(FloatingActionButton(this))
           /* Toast.makeText(this, "clicked Change fab", Toast.LENGTH_SHORT).show()
            uiHandler.postDelayed({ fab.menuIconView.setImageResource(R.drawable.ic_action_ball) }, 4000)*/
        }
        fab.setOnMenuButtonClickListener{v ->
            if (state == 1) {
                Toast.makeText(this, "Clicked Menu ", Toast.LENGTH_SHORT).show()
            } else {
                fab.toggle(true)
            }
        }
    }

    inner class FloatingActionMenuExtension : FloatingActionMenu(this) {
        init {
//            this.menuIconView
        }
    }

}


