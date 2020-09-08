package com.bmk.daggerproject.ui.list

import dagger.Binds
import dagger.Module

@Module
public abstract class ListModule {

    @Binds
    abstract fun provideListFra(fragment: ListFragment): ListContract

//    @Binds
//    abstract fun provideListPresenter(): ListPresenter

}