package com.gopi.architecture.sample.samplearchitectureapp.workmanager

import android.os.Bundle
import android.support.annotation.WorkerThread
import android.support.v7.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.impl.WorkManagerImpl
import com.gopi.architecture.sample.samplearchitectureapp.R


class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
    }

    private fun doLogic() {
//        val reqBuilder = OneTimeWorkRequest.Builder().
//        WorkManager.getInstance().enqueue(reqBuilder)
//        OneTimeWorkRequest().
//        OneTimeWorkRequest.Builder()
    }



}
