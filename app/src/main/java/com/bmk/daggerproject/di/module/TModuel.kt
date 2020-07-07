package com.bmk.daggerproject.di.module

import com.bmk.daggerproject.ui.main.ActivityModule
import com.bmk.daggerproject.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TModuel {
    @ContributesAndroidInjector(modules = [(ActivityModule::class)])
    abstract fun contributeActivityAndroidInjector(): MainActivity
}