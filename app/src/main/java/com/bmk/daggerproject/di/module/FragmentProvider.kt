package com.bmk.daggerproject.di.module

import com.bmk.daggerproject.ui.about.AboutFragment
import com.bmk.daggerproject.ui.about.AboutUsModule
import com.bmk.daggerproject.ui.list.LiftModule
import com.bmk.daggerproject.ui.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by manish on 07/07/201820.
 */
@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector(modules = [AboutUsModule::class])
    abstract fun providesAboutFragment(): AboutFragment

    @ContributesAndroidInjector(modules = [LiftModule::class])
    abstract fun providesListFragment(): ListFragment
}