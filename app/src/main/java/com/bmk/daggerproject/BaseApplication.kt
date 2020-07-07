package com.bmk.daggerproject

import com.bmk.daggerproject.di.component.ApplicationComponent
import com.bmk.daggerproject.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by ogulcan on 07/02/2018.
 */
class BaseApplication : DaggerApplication() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .also { this.component = it }
    }


    companion object {
        lateinit var instance: BaseApplication private set
    }
}