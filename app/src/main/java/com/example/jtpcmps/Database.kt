package com.example.jtpcmps

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "records")
class RecordList {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var id: Int = 0
    @ColumnInfo(name = "UserName")
    var result: Int = 0
    var name: String = ""


    constructor() {}

    constructor(name: String, result: Int) {
        this.name = name
        this.result = result
    }
}

