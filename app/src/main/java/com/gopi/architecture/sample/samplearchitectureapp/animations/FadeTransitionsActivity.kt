package com.gopi.architecture.sample.samplearchitectureapp.animations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.gopi.architecture.sample.samplearchitectureapp.R
import kotlinx.android.synthetic.main.activity_fade_transitions.*

class FadeTransitionsActivity : AppCompatActivity() {
    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fade_transitions)
        transNext.setOnClickListener {
            if(count == 1){
                commitFragment(TransitionFirstFragment())
                count++
            } else {
                commitFragment(TransitionSecondFragment())
                count = 1
            }
        }
    }

    private fun commitFragment(fragment: Fragment) {
        Thread() {
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            beginTransaction.replace(R.id.transFragmentContainer, fragment).commitAllowingStateLoss()
        }.start()
    }
}
