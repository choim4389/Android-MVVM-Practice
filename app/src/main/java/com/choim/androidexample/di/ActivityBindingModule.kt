package com.choim.androidexample.di

import com.choim.androidexample.di.module.MainActivityModule
import com.choim.androidexample.di.scope.PerActivity
import com.choim.androidexample.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class
    ])
    abstract fun bindMainActivity(): MainActivity

}