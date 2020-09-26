package com.bmk.daggerproject.di.module

import com.bmk.daggerproject.data.MatchRepositoryImpl
import com.bmk.daggerproject.domain.MatchRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(EncodedString::class.java, EncodedStringTypeAdapter().nullSafe())
            .registerTypeAdapter(Date::class.java, DateTypeAdapter().nullSafe())
            .create()
    }

    @Provides
    fun provideRepository(repository: MatchRepositoryImpl): MatchRepository {
        return repository
    }

}