package com.gopi.architecture.sample.samplearchitectureapp

import android.content.ComponentName
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityAliasFunctionalityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alias_functionality)

        val intent = intent
        val cn = intent.component
        Thread(){  // can do in same thread or bg thread.
            packageManager.setComponentEnabledSetting(ComponentName(packageName, packageName + ".AliasShareActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
            packageManager.setComponentEnabledSetting(ComponentName(packageName, packageName + ".shareactivity.ShareActivity"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP) }.start()
    }
}
