package com.bmk.daggerproject.ui.about

import dagger.Module
import dagger.Provides

@Module
public class AboutUsModule {

    @Provides
    fun provideAboutFragment(fragment: AboutFragment): AboutContract {
        return fragment
    }

    @Provides
    fun getScreenParam(fragment: AboutFragment): String? {
        val d = fragment.arguments
        return d?.getString(AboutFragment.ARGS_ABOUT)
    }

}