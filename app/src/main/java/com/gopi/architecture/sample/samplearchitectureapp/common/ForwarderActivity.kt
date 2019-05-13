package com.gopi.architecture.sample.samplearchitectureapp.common

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.UIStuff.snackBar.SnackBarActivity
import com.gopi.architecture.sample.samplearchitectureapp.animations.FadeTransitionsActivity
import com.gopi.architecture.sample.samplearchitectureapp.keyboardIssues.KeyboardIssuesActivity

class ForwarderActivity : AppCompatActivity() {
    var classToForward = KeyboardIssuesActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forwarder)
        startActivity(Intent(this, classToForward))
    }
}
