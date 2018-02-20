package com.choim.androidexample.di.module

import android.arch.lifecycle.ViewModelProviders
import com.choim.androidexample.di.scope.PerActivity
import com.choim.androidexample.ui.MainActivity
import com.choim.androidexample.viewmodel.MainViewModel
import com.choim.androidexample.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
abstract class MainActivityModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        @PerActivity
        fun provideMainViewModel(activity: MainActivity, viewModelFactory: MainViewModelFactory): MainViewModel {
            return ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel::class.java)
        }
    }

}