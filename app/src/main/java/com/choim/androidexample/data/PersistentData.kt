package com.choim.androidexample.data

import android.content.Context
import com.choim.androidexample.di.qualifier.AppContext
import com.choim.androidexample.model.User
import com.google.gson.Gson
import javax.inject.Inject


class PersistentData @Inject constructor(@AppContext context: Context): DataSource {

    val pref = context.getSharedPreferences("local_data", Context.MODE_PRIVATE)
    val cache: HashMap<String, Any?> = HashMap(pref.all)
    val gson = Gson()

    private fun getString(key: String): String? {
        return cache[key] as? String
    }

    private fun putString(key: String, value: String) {
        cache.put(key, value)
        pref.edit().putString(key, value).apply()
    }

    override fun getUser(): User{
        val userString = getString("user")
        if(userString == null) {
            val user = User("macan", 28, "푸르지오시티 3차")
            updateUser(user)
            return user
        } else {
            gson.fromJson(getString("user"), User::class.java)
        }
        return gson.fromJson(getString("user"), User::class.java)
    }

    override fun updateUser(user: User) {
        putString("user", gson.toJson(user))
    }
}