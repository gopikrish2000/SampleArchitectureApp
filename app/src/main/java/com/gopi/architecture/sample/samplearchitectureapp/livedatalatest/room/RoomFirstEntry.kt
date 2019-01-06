package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "RoomFirstEntry") // by default tableName is equal to classname && columnName = variableName
data class RoomFirstEntry(@PrimaryKey(autoGenerate = true) val id: Int? = null, val name: String, val age: Int, @ColumnInfo(name = "description") val description: String) {
}