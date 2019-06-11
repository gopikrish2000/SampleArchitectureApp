package com.gopi.architecture.sample.samplearchitectureapp

import android.app.Application
import android.os.Handler
import com.facebook.drawee.backends.pipeline.Fresco

class MainApplication : Application() {

    companion object {
        lateinit private var instance: MainApplication

        fun getAppContext(): MainApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)
    }

    fun showToast(msg:String){

    }
}