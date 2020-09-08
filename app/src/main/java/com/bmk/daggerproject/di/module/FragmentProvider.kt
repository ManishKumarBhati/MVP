package com.bmk.daggerproject.di.module

import com.bmk.daggerproject.ui.about.PlayerFragment
import com.bmk.daggerproject.ui.about.PlayerModule
import com.bmk.daggerproject.ui.list.TeamFragment
import com.bmk.daggerproject.ui.list.TeamModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by manish on 07/07/201820.
 */
@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector(modules = [PlayerModule::class])
    abstract fun providesPlayerFragment(): PlayerFragment

    @ContributesAndroidInjector(modules = [TeamModule::class])
    abstract fun providesTeamFragment(): TeamFragment
}