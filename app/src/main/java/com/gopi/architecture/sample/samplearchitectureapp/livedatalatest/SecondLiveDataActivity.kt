package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.databinding.ActivitySecondLiveDataBinding

class SecondLiveDataActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondLiveDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second_live_data)
        binding = DataBindingUtil.setContentView<ActivitySecondLiveDataBinding>(this, R.layout.activity_second_live_data)
        binding.setLifecycleOwner(this)
        var bottomViewModel = LiveDataBottomVM.getActiveInstance()
//        var bottomViewModel = LiveDataBottomVM.objInstan!!
//        var bottomViewModel = DummyJava.liveDataBottomVM
//       var bottomViewModel = ViewModelProviders.of(this).get(LiveDataBottomVM::class.java)

        binding.liveDataBottomVM = bottomViewModel
        binding.liveDataBottomPortion.liveDataBottomVM = bottomViewModel
//        binding.liveDataVM = FirstLiveData()
//        bottomViewModel.doBottomBarProcess()
//        binding.root.requestLayout()
//        bottomViewModel.firstData.observe(this, Observer{ binding.root.requestLayout()})
    }
}
