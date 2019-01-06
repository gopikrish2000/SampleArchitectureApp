package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    lateinit var firstLiveData: FirstLiveData
    lateinit var binding: ActivityLiveDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)
        doInit()
        doLogic()
    }

    private fun doInit() {
        firstLiveData = ViewModelProviders.of(this).get(FirstLiveData::class.java)
        binding.setLifecycleOwner(this)   // Set this line to make data binding use live data.
        binding.livedataVM = firstLiveData
        firstLiveData.doSomeProcessing()

        /*firstLiveData.name.observe(this , Observer {   // no need of this if u r just using to update the ui.
//            liveDataTv.text = it
            Toast.makeText(this,"value is $it", Toast.LENGTH_LONG).show()
        })*/
    }

    private fun doLogic() {

    }
}
