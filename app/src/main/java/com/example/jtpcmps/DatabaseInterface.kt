package com.example.jtpcmps

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseInterface {
    @Insert
    suspend fun insert(item:RecordList)

    @Query("SELECT * FROM records ORDER BY UserName DESC")
    fun getAllItems(): LiveData<List<RecordList>>
}

