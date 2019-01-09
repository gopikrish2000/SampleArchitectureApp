package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface RoomFirstDao {

    @Query("SELECT * from RoomFirstEntry")
    fun getAllRoomEntries(): List<RoomFirstEntry>

    @Query("SELECT * from RoomFirstEntry")
    fun getAllRoomEntriesLiveData(): LiveData<List<RoomFirstEntry>>

    @Query("SELECT * from RoomFirstEntry WHERE name == :nameInput  limit 1")
    fun getSecondRoomEntries(nameInput: String): LiveData<RoomFirstEntry>


    @Query("UPDATE RoomFirstEntry SET description = :nameInput  WHERE name == :findName")
    fun updateRoomEntry(nameInput: String, findName: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoomEntry(item: RoomFirstEntry)

}