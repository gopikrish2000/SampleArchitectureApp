package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [RoomFirstEntry::class], version = 1)
abstract class LiveDataRoomDb : RoomDatabase() {
    abstract fun firstDao(): RoomFirstDao

    companion object {
        private var INSTANCE: LiveDataRoomDb? = null

        fun getAppDataBase(context: Context): LiveDataRoomDb? {
            if (INSTANCE == null) {
                synchronized(LiveDataRoomDb::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, LiveDataRoomDb::class.java, "gopiDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}