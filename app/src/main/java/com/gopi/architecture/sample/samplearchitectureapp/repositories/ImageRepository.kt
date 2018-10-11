package com.gopi.architecture.sample.samplearchitectureapp.repositories

import com.gopi.architecture.sample.samplearchitectureapp.datasources.ImageLocalFileDataSource
import com.gopi.architecture.sample.samplearchitectureapp.datasources.ImageNetworkDataSource
import com.gopi.architecture.sample.samplearchitectureapp.pojos.ImageData


class ImageRepository private constructor(){

    private val networkDataSource:ImageNetworkDataSource;
    private val localDataSource:ImageLocalFileDataSource;

    init {
        networkDataSource = ImageNetworkDataSource()
        localDataSource = ImageLocalFileDataSource()
    }


    companion object {
        private var instance: ImageRepository? = null;
        fun getInstance(): ImageRepository {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) return ImageRepository()
                }
            }
            return instance!!;
        }
    }

    fun fetchRandomImages(count: Int) : MutableList<ImageData> {
        val resultList = arrayListOf<ImageData>()
        resultList.addAll(networkDataSource.fetchData(count-1))
        resultList.addAll(localDataSource.fetchData(1))
        return resultList
    }

}

interface FetchDataInterface {
    fun fetchData(count: Int): MutableList<ImageData>
}