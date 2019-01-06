package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FirstLiveData : ViewModel() {

    val name: MutableLiveData<String>
    val age: MutableLiveData<Int>
    val mediatorNameAge: MediatorLiveData<String>
    init {
        name = MutableLiveData()
        age = MutableLiveData()
        mediatorNameAge = MediatorLiveData()
        mediatorNameAge.addSource(name) { mediatorNameAge.postValue(it.toString()) }
        mediatorNameAge.addSource(age) { mediatorNameAge.postValue(it.toString()) }
    }

    fun doSomeProcessing(){
        val random = (Math.random() * 7).toInt()

        val stringList = mutableListOf("a", "b", "c", "d", "e", "f", "g")
        val input = stringList[random]
        Observable.just(input).delay(5, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe { name.postValue(input) }

        Observable.just(input).delay(3, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe { age.postValue(random) }
    }

    override fun onCleared() {
        super.onCleared()
        // subscriptions clear.
    }
}