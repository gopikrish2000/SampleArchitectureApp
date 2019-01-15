package com.gopi.architecture.sample.samplearchitectureapp.workmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager


class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

//        handleMessageOther()
        val intent = intent
        val cn = intent.component
        packageManager.setComponentEnabledSetting(ComponentName(packageName, packageName + ".AliasShareActivity"),PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP)
        packageManager.setComponentEnabledSetting(ComponentName(packageName, packageName + ".shareactivity.ShareActivity"),PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP)

    }

    private fun handleMessage() {  // this will crash bcoz method is returned
        try {
            Handler(Looper.getMainLooper()).postDelayed({
                1 / 0
            }, 2000)
        } catch (e: Exception) {
            Toast.makeText(this,"HandledMessage", Toast.LENGTH_LONG).show()
        }
    }

    private fun handleMessageOther() {  // this will also crash bcoz method is returned
        try {
            Observable.just(2).delay(10, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe { 1/0 }
        } catch (e: Exception) {
            Toast.makeText(this,"HandledMessage", Toast.LENGTH_LONG).show()
        }
    }
}

class BackgroundTemp {

    fun doInBackground(){

//        Observable.just(2).delay(10, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
    }
}
