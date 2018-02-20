package com.choim.androidexample.di.module

import android.content.Context
import com.choim.androidexample.application.Application
import com.choim.androidexample.data.DataSource
import com.choim.androidexample.data.PersistentData
import com.choim.androidexample.di.qualifier.AppContext


import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @com.choim.androidexample.di.qualifier.PersistentData
    abstract fun providePersistentData(persistentData: PersistentData): DataSource


    @Binds
    @AppContext
    abstract fun provideContext(application: Application): Context

}