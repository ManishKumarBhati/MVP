package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.api.ApiServiceInterface
import com.bmk.daggerproject.ui.list.ListContract
import com.bmk.daggerproject.ui.list.ListFragment
import com.bmk.daggerproject.ui.list.ListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
public abstract class LiftModule {

    @Binds
    abstract fun provideListFra(fragment: ListFragment): ListContract

//    @Binds
//    abstract fun provideListPresenter(): ListPresenter

}