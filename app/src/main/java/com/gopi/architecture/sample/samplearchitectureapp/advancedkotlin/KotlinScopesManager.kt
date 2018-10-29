package com.gopi.architecture.sample.samplearchitectureapp.advancedkotlin

import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.MainApplication


class KotlinScopesManager {

    fun receiverLambdaFirst(lambda: KotlinReceiver.() -> Unit) {
        KotlinReceiver("first").lambda()
    }


    class KotlinReceiver(var name: String)

    fun main(args: Array<String>) {
        receiverLambdaFirst { Toast.makeText(MainApplication.getAppContext(), "receiver", Toast.LENGTH_SHORT).show() }
    }
}