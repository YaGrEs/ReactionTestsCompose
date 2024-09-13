package com.example.jtpcmps

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(RecordList::class)], version = 1)
abstract class Recordatabase: RoomDatabase() {

    abstract fun userDao(): DatabaseInterface

    companion object {
        private var INSTANCE: Recordatabase? = null
        fun getInstance(context: Context): Recordatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Recordatabase::class.java,
                        "usersdb"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}