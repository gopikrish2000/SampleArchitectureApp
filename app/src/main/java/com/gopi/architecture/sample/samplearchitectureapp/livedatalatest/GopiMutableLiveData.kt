package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest

import android.arch.lifecycle.MutableLiveData
import android.util.Log

class GopiMutableLiveData<String> : MutableLiveData<String>() {
    var activeCount:Int = 0

    override fun onInactive() {
        super.onInactive()
        activeCount--
        Log.i("Gopi","GopiMutableLiveData onInActive() called $activeCount")
    }


    override fun onActive() {
        super.onActive()
        activeCount++
        Log.i("Gopi","GopiMutableLiveData onActive() called $activeCount")
    }

    companion object {  // can make it as singleton n can be used across activities.
        private lateinit var instance : GopiMutableLiveData<String>

        fun getInstanceGopi():GopiMutableLiveData<String>{
            return if(::instance.isInitialized) instance else GopiMutableLiveData()
        }
    }
}