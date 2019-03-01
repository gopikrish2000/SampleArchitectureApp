package com.gopi.architecture.sample.samplearchitectureapp.common

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.LiveDataActivity
import com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.SecondLiveDataActivity
import com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.room.RoomLiveDataTestActivity
import com.gopi.architecture.sample.samplearchitectureapp.parallaxAnimation.ParallaxAnimationActivity
import com.gopi.architecture.sample.samplearchitectureapp.rxjavaLatest.RxjavaPracActivity
import com.gopi.architecture.sample.samplearchitectureapp.services.ForegroundServiceActivity
import com.gopi.architecture.sample.samplearchitectureapp.workmanager.WorkManagerActivity

class ForwarderActivity : AppCompatActivity() {
    var classToForward = ParallaxAnimationActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forwarder)
        startActivity(Intent(this, classToForward))
    }
}
