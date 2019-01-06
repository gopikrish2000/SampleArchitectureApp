package com.gopi.architecture.sample.samplearchitectureapp.common

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.LiveDataActivity
import com.gopi.architecture.sample.samplearchitectureapp.rxjavaLatest.RxjavaPracActivity

class ForwarderActivity : AppCompatActivity() {
    var classToForward = LiveDataActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forwarder)
        startActivity(Intent(this, classToForward))
    }
}
