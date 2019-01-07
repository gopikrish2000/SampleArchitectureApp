package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LiveDataBottomVM : ViewModel() {

    val firstData:MutableLiveData<String> = MutableLiveData()
    val secondData:MutableLiveData<String> = MutableLiveData()
    val thirdData: LiveData<String> = Transformations.map(firstData){ it.plus("changedddd")}

    fun doBottomBarProcess() {
        val random = (Math.random() * 7).toInt()

        val stringList = mutableListOf("1a", "2b", "3c", "4d", "5e", "6f", "7g")
        val input = stringList[random]
        Observable.just(input).delay(5, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe { firstData.postValue(input) }

        Observable.just(input).delay(3, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe { secondData.postValue(random.toString()) }
    }

    companion object {
        private var INSTANCE: LiveDataBottomVM? = null

        fun getInstance(): LiveDataBottomVM{
            return if(INSTANCE != null) INSTANCE!! else LiveDataBottomVM()
        }


    }
}