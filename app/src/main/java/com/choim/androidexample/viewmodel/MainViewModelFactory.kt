package com.choim.androidexample.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.choim.androidexample.data.DataSource
import com.choim.androidexample.di.qualifier.PersistentData
import javax.inject.Inject


class MainViewModelFactory @Inject constructor(@PersistentData val dataSource: DataSource): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(dataSource) as T
    }

}