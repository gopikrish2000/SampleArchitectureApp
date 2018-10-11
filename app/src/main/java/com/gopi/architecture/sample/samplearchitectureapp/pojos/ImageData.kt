package com.gopi.architecture.sample.samplearchitectureapp.pojos

open class ImageData(var type: String)

data class ImageDataNetwork(val networkUrl: String) : ImageData("network")

data class ImageDataLocal(val networkUrl: String) : ImageData("local")