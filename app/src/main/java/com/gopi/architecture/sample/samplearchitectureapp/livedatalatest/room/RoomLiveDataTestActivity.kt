package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.room

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.R
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomLiveDataTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_live_data_test)
        val firstDao = LiveDataRoomDb.getAppDataBase(this)?.firstDao()

        Completable.create {
            firstDao?.insertRoomEntry(RoomFirstEntry(age = 22, name = "def", description = "werew"))
            firstDao?.insertRoomEntry(RoomFirstEntry(age = 28, name = "abc", description = "tyrty"))
            firstDao?.insertRoomEntry(RoomFirstEntry(age = 118, name = "yuiyi", description = "iii"))
            Log.i("GopiData", "GopigetAlldata" + firstDao?.getAllRoomEntries())
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()

        firstDao?.getAllRoomEntriesLiveData()?.observe(this, Observer{  // automatically get livedata from the db. Also no need to put in bg thread.
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
        })
    }
}
