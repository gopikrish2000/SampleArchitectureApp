package com.gopi.architecture.sample.samplearchitectureapp.MORELATEST2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gopi.architecture.sample.samplearchitectureapp.R

class FirstCoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_coroutine)
        doSample()
    }

    fun doSample(): Double {
        Thread.sleep(5000)
        var number = 25.0
        val result = Math.pow(number, 10.0)
        return result
    }
}
