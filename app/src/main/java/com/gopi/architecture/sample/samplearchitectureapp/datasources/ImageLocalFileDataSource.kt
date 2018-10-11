package com.gopi.architecture.sample.samplearchitectureapp.datasources

import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageData
import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageDataLocal
import com.gopi.architecture.sample.samplearchitectureapp.repositories.FetchDataInterface

class ImageLocalFileDataSource : FetchDataInterface {

    override fun fetchData(count: Int): MutableList<ImageData> {
        var list: MutableList<ImageData> = arrayListOf()
        for (i in 1..count){
            list.add(ImageDataLocal(""))
        }
        return list
    }

}