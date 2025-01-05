package com.example.jtpcmps

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RecordRepository(private val userDao: DatabaseInterface) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val userList: LiveData<List<RecordList>> = userDao.getAllItems()

    fun addUser(User: RecordList) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.insert(User)
        }
    }
}