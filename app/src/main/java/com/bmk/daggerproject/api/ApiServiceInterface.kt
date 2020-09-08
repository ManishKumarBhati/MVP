package com.bmk.daggerproject.api

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by manish on 07/07/201820.
 */
interface ApiServiceInterface {
    @GET("sapk01222019186652.json")
    fun getPostList(): Single<String>
}