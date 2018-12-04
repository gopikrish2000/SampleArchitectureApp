package com.gopi.architecture.sample.samplearchitectureapp.testPackage

import android.os.Parcel
import android.os.Parcelable

class TestKotlinParcelable() : Parcelable {
    var a:Int = 0
    var aDouble: Double = 2.0
    var name:String = ""

    constructor(parcel: Parcel) : this() {
        a = parcel.readInt()
        aDouble = parcel.readDouble()
        name = parcel.readString()
    }

    fun abc() {
        var a = 10
        var abc = "MY-FIRST-NAME"
        if(a > 5){
            if(a < 10) {
                if(a > 100){
                    if( a> 999){

                    }
                }
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(a)
        parcel.writeDouble(aDouble)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestKotlinParcelable> {
        override fun createFromParcel(parcel: Parcel): TestKotlinParcelable {
            return TestKotlinParcelable(parcel)
        }

        override fun newArray(size: Int): Array<TestKotlinParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

fun main(args: Array<String>) {
    TestKotlinParcelable().abc()
}