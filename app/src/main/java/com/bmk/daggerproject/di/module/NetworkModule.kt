package com.bmk.daggerproject.di.module

import android.util.Log
import com.bmk.daggerproject.api.ApiServiceInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


@Module
class NetworkModule {


    @Provides
    fun provideApiService(): ApiServiceInterface {
        val logger = HttpLoggingInterceptor(HttpLoggingInterceptor
            .Logger { message: String? -> Log.d("OkHttp", message) }
        ).setLevel(HttpLoggingInterceptor.Level.BODY)

        val okClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        return ApiServiceInterface.create(okClient)
    }
}