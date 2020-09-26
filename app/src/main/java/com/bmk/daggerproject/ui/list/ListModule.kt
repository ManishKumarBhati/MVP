package com.bmk.daggerproject.ui.list

import dagger.Module
import dagger.Provides

@Module
public class ListModule {

    @Provides
    fun provideAboutFragment(fragment: ListFragment): ListContract {
        return fragment
    }

}