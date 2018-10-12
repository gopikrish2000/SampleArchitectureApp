package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun View.setGone(){
    this.visibility = View.GONE
}

fun View.setVisible(){
    this.visibility = View.VISIBLE
}

fun View.setInVisible(){
    this.visibility = View.INVISIBLE
}