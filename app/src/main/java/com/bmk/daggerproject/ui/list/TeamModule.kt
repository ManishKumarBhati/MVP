package com.bmk.daggerproject.ui.list

import dagger.Binds
import dagger.Module

@Module
public abstract class TeamModule {

    @Binds
    abstract fun provideListFra(fragment: TeamFragment): TeamContract

//    @Binds
//    abstract fun provideListPresenter(): ListPresenter

}