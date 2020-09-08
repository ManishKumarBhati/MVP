package com.bmk.daggerproject.di.module

import android.app.Application
import android.content.Context
import com.bmk.daggerproject.BaseApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideContext(application: BaseApplication): Context

    @Binds
    abstract fun provideApplication(application: BaseApplication): Application
}

