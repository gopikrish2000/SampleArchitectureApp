package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gopi.architecture.sample.samplearchitectureapp.R
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomLiveDataTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_live_data_test)

        Completable.create {
            LiveDataRoomDb.getAppDataBase(this)?.firstDao()?.insertRoomEntry(RoomFirstEntry(age = 22, name = "def", description = "werew"))
            LiveDataRoomDb.getAppDataBase(this)?.firstDao()?.insertRoomEntry(RoomFirstEntry(age = 28, name = "abc", description = "tyrty"))
            LiveDataRoomDb.getAppDataBase(this)?.firstDao()?.insertRoomEntry(RoomFirstEntry(age = 118, name = "yuiyi", description = "iii"))
            Log.i("GopiData", "GopigetAlldata" + LiveDataRoomDb.getAppDataBase(this)?.firstDao()?.getAllRoomEntries())
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
}
