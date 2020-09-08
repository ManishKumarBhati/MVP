package com.bmk.daggerproject.di.module

import com.bmk.daggerproject.ui.about.PlayerFragment
import com.bmk.daggerproject.ui.about.PlayerModule
import com.bmk.daggerproject.ui.list.ListFragment
import com.bmk.daggerproject.ui.list.ListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by manish on 07/07/201820.
 */
@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector(modules = [PlayerModule::class])
    abstract fun providesPlayerFragment(): PlayerFragment

    @ContributesAndroidInjector(modules = [ListModule::class])
    abstract fun providesListFragment(): ListFragment
}