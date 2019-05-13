package com.gopi.architecture.sample.samplearchitectureapp.animations


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gopi.architecture.sample.samplearchitectureapp.R
import android.view.WindowManager
import kotlinx.android.synthetic.main.fragment_transition_first.*


class TransitionFirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setKeyboardState()
        return inflater.inflate(R.layout.fragment_transition_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onb_profile_name.requestFocus()
        setKeyboardState()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setKeyboardState()
    }

    override fun onResume() {
        super.onResume()
        onb_profile_name.requestFocus()
        setKeyboardState()
    }

    private fun setKeyboardState() {
        activity!!.window.setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        // WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or
    }
}
