package com.choim.androidexample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.choim.androidexample.data.DataSource
import com.choim.androidexample.model.User
import javax.inject.Inject


class MainViewModel @Inject constructor(val dataSource: DataSource) : ViewModel() {

    private val user: MutableLiveData<User> by lazy { MutableLiveData<User>().apply { value = dataSource.getUser() } }

    fun updateUserProperty(name: String, age: Int, address: String) {

        val newUser = User(name, age, address)
        user.value = newUser
        dataSource.updateUser(newUser)
    }

    fun getUser(): LiveData<User> {
        return user
    }

    override fun onCleared() {
        super.onCleared()
        //rx disposable clear
    }
}