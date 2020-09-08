package com.bmk.daggerproject.di.module

import com.bmk.daggerproject.data.MatchRepositoryImpl
import com.bmk.daggerproject.domain.MatchRepository
import dagger.Binds
import dagger.Module


@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: MatchRepositoryImpl): MatchRepository
}