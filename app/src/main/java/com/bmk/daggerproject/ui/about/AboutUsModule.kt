package com.bmk.daggerproject.ui.about

import dagger.Binds
import dagger.Module

@Module
public abstract class AboutUsModule {

    @Binds
    abstract fun provideAboutFragment(fragment: AboutFragment): AboutContract
}