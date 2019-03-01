package com.gopi.architecture.sample.samplearchitectureapp.services

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gopi.architecture.sample.samplearchitectureapp.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/*
* 1. Service can start in background thread as well
* 2. Stopping it explicitly won’t terminate it as long as there are bound components, and unbinding all components won’t terminate it until it’s explicitly stopped (if it was ever started). Also note that no matter how many times you call startService(), a single call to stopService() or stopSelf() will stop it.
* 3. Non Foreground Service when went background for 15 seconds approx will stop automatically from Android_O n above with logs
*   I/ActivityManager: Waited long enough for: ServiceRecord{7e04f08 u0 com.gopi.architecture.sample.samplearchitectureapp/.services.FirstForegroundService}
*   W/ActivityManager: Stopping service due to app idle: u0a291 -1m12s879ms com.gopi.architecture.sample.samplearchitectureapp/.services.FirstForegroundService
*   I/System.out: FirstForegroundService destroy called  (calling on destroy method )
*
* */
class ForegroundServiceActivity : AppCompatActivity() {
    lateinit var serviceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_service)

        serviceIntent = Intent(this, FirstForegroundService::class.java).apply { putExtra("firstParam", "firstParam") }
//        startService(intent)
//        stopService(intent)
        Observable.just(1).delay(10, TimeUnit.SECONDS).observeOn(Schedulers.computation()).subscribeOn(Schedulers.computation()).subscribe { startService(serviceIntent) }
    }

    override fun onStop() {
        super.onStop()
//        startService(serviceIntent)
    }
}
