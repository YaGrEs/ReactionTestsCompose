package com.example.jtpcmps

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class UserViewModel(application: Application) : ViewModel() {

    val userList: LiveData<List<RecordList>>
    private val repository: RecordRepository
    var userName by mutableStateOf("")
    var userScore by mutableStateOf(0)

    init {
        val userDb = Recordatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = RecordRepository(userDao)
        userList = repository.userList
    }
    fun changeName(value: String){
        userName = value
    }
    fun changeResult(value: String){
        userScore = value.toIntOrNull()?:userScore
    }
    fun addUser() {
        repository.addUser(RecordList(userName, userScore))
    }
}