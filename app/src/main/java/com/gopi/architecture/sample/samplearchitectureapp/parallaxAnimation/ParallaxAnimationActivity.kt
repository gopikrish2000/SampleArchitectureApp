package com.gopi.architecture.sample.samplearchitectureapp.parallaxAnimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gopi.architecture.sample.samplearchitectureapp.R
import kotlinx.android.synthetic.main.activity_parallax_transition.*

class ParallaxAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax_transition)
        initViews()
    }

    private fun initViews() {
        profileRv.layoutManager = LinearLayoutManager(this)
        val parallaxAnimationAdapter = ParallaxAnimationAdapter(mutableListOf(ParallaxItem("first"),ParallaxItem("second"), ParallaxItem("third"),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem(),ParallaxItem())) { item, position ->
        }
        profileRv.adapter = parallaxAnimationAdapter
    }

}
