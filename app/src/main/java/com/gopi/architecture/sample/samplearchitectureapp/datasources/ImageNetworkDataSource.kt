package com.gopi.architecture.sample.samplearchitectureapp.datasources

import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageData
import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageDataNetwork
import com.gopi.architecture.sample.samplearchitectureapp.repositories.FetchDataInterface
import java.util.*

class ImageNetworkDataSource : FetchDataInterface {

    override fun fetchData(count: Int): MutableList<ImageData> {
        val max = 11
        val min = 1
        val list = arrayListOf<ImageData>()
        var i = 0
        while (i < count) {
            val randomVal = Random().nextInt((max - min) + 1) + min
            val item = ImageDataNetwork("https://via.placeholder.com/350x150/FFC0CB/ffffff?text=" + randomVal)
            list.add(item)
            i++
        }
        return list
    }

}