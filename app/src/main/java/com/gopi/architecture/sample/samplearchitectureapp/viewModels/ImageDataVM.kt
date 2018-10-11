package com.gopi.architecture.sample.samplearchitectureapp.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageData
import com.gopi.architecture.sample.samplearchitectureapp.repositories.ImageRepository

class ImageDataVM(var type:String): ViewModel() {
    var imageDataList : MutableLiveData<MutableList<ImageData>>
    private var imageDataCompleteList: MutableList<ImageData>

    init {
        imageDataList = MutableLiveData()
        imageDataCompleteList = mutableListOf()
    }

    fun fetchRandomImages(count: Int) {
        val elements = ImageRepository.getInstance().fetchRandomImages(count)
        imageDataCompleteList.addAll(elements)
        imageDataList.value = elements
    }

}


