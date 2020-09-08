package com.bmk.daggerproject.ui.about

import dagger.Module
import dagger.Provides

@Module
public class PlayerModule {

    @Provides
    fun provideAboutFragment(fragment: PlayerFragment): PlayerContract {
        return fragment
    }

    @Provides
    fun getScreenParam(fragment: PlayerFragment): String? {
        val d = fragment.arguments
        return d?.getString(PlayerFragment.ARGS_PLAYER)
    }

}