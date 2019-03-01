package com.gopi.architecture.sample.samplearchitectureapp.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.CLASS_TAG

class FirstForegroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate(){
        super.onCreate()
        println("${CLASS_TAG} onCreate called for service")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val bundleString = StringBuffer("")
        intent?.extras?.keySet()?.forEach { bundleString.append("key - $it ;; value - ${intent.extras[it]} ") }
        println("$CLASS_TAG onStartCommand called with intent data $bundleString")
//        stopSelf()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$CLASS_TAG destroy called")
    }
}