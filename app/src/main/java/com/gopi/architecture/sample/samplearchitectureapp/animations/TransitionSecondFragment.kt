package com.gopi.architecture.sample.samplearchitectureapp.animations


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gopi.architecture.sample.samplearchitectureapp.R

class TransitionSecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transition_second, container, false)
    }
}
