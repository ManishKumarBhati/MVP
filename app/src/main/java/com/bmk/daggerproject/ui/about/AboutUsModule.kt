package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.api.ApiServiceInterface
import com.bmk.daggerproject.ui.list.ListFragment
import com.bmk.daggerproject.ui.list.ListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
public abstract class AboutUsModule {

    @Binds
    abstract fun provideAboutFragment(fragment: AboutFragment): AboutContract

//    @Provides
//    fun provideAboutPresenter(fragment: AboutFragment): AboutPresenter {
//        return AboutPresenter(fragment)
//    }
}