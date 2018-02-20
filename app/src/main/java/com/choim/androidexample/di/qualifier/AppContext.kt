package com.choim.androidexample.di.qualifier

import javax.inject.Qualifier


@Qualifier
@Target(AnnotationTarget.FUNCTION, // provider
        AnnotationTarget.VALUE_PARAMETER, // constructor injection
        AnnotationTarget.FIELD // member injection
)
@Retention(AnnotationRetention.RUNTIME)
annotation class AppContext