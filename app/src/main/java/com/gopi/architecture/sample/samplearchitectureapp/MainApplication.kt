package com.gopi.architecture.sample.samplearchitectureapp

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class MainApplication : Application() {

    companion object {
        lateinit private var instance: MainApplication

        fun getAppContext(): Application {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)
    }
}