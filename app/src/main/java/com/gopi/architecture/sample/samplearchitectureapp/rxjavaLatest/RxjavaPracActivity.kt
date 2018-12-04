package com.gopi.architecture.sample.samplearchitectureapp.rxjavaLatest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gopi.architecture.sample.samplearchitectureapp.R
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rxjava_prac.*
import java.util.concurrent.TimeUnit

class RxjavaPracActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava_prac)

        rxBtn.setOnClickListener {

            Flowable.create(FlowableOnSubscribe<Int> {
                it.onNext(8)
                it.onComplete()
            }, BackpressureStrategy.LATEST).delay(16,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation()).subscribe{ rxTextTv.setText("Flowable $it")}

            Flowable.create(object : FlowableOnSubscribe<Int> {
                override fun subscribe(emitter: FlowableEmitter<Int>) {
                    emitter.onNext(8)
                    emitter.onComplete()
                }
            }, BackpressureStrategy.LATEST).delay(3,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation()).subscribe{ rxTextTv.setText("Flowable $it")}
            Observable.create<Int> { it.onNext(1); it.onComplete() }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation()).subscribe ({ rxTextTv.setText("Observable $it") }) { println("error ${it.message}")}

            val singleObservable = Single.create<Int> { it.onSuccess(4); }.delay(5,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation())
            singleObservable.subscribeWith(object : DisposableSingleObserver<Int>() {
                override fun onSuccess(t: Int) {
                    rxTextTv.setText("Single $t")
                }

                override fun onError(e: Throwable) {
                }
            })

            val maybe = Maybe.create<Int> { it.onSuccess(9); }.delay(7,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation())
            maybe.subscribeWith(object : DisposableMaybeObserver<Int>() {
                override fun onComplete() {
                }

                override fun onSuccess(t: Int) {
                    rxTextTv.setText("Maybe $t")
                }

                override fun onError(e: Throwable) {
                }
            })

            Completable.create { it.onComplete() }.delay(13,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe({ rxTextTv.setText("Completable completed") }){rxTextTv.setText("Completable Error")}

            Flowable.fromCallable { 10}.delay(20,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe { rxTextTv.setText("FlowableFromCallable $it") }  // shorthand way of creating observables without emitter.onNext() & emiter.onCompleted()

        }
    }
}
