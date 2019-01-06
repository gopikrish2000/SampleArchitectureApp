package com.gopi.architecture.sample.samplearchitectureapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.gopi.architecture.sample.samplearchitectureapp.adapters.ImagePresenterAdapter
import com.gopi.architecture.sample.samplearchitectureapp.viewModels.ImageDataVM

class MainActivity : AppCompatActivity() {
    lateinit var imageVM: ImageDataVM
    lateinit var adapter: ImagePresenterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initLogic()
    }

    private fun initViews() {
        val recyclerView = findViewById<RecyclerView>(R.id.image_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ImagePresenterAdapter()
        recyclerView.adapter = adapter

    }

    private fun initLogic() {
        imageVM = ViewModelProviders.of(this).get(ImageDataVM::class.java)
        imageVM.imageDataList.observe(this, Observer { list ->
            val itemList = list ?: mutableListOf()
            adapter.addItems(itemList)
        })
        imageVM.fetchRandomImages(3)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
