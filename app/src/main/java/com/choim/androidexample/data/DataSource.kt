package com.choim.androidexample.data

import com.choim.androidexample.model.User


interface DataSource {

    fun getUser(): User
    fun updateUser(user: User)
}