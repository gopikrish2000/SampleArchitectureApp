package com.gopi.architecture.sample.samplearchitectureapp.keyboardIssues

import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gopi.architecture.sample.samplearchitectureapp.R
import android.view.WindowManager



class KeyboardIssuesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_keyboard_issue)

//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        Handler(Looper.getMainLooper()).postDelayed({
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            supportFragmentManager.beginTransaction().replace(R.id.keyboardRoot, KeyboardIssueFragment()).commitAllowingStateLoss()
        }, 4000)
//        supportFragmentManager.beginTransaction().replace(R.id.keyboardRoot, KeyboardIssueFragment()).commitAllowingStateLoss()

    }
}
