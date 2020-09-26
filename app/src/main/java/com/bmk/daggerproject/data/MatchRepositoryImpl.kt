package com.bmk.daggerproject.data

import android.content.Context
import com.bmk.daggerproject.domain.MatchRepository
import com.bmk.daggerproject.domain.ResponseData
import com.bmk.daggerproject.util.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import java.lang.reflect.Type
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    val gson: Gson,
    val context: Context
) : MatchRepository {
    override fun getMatchData(): Observable<ResponseData> {
        return Observable.fromCallable {
            val dataType: Type = object : TypeToken<ResponseData>() {}.type
            (gson.fromJson(Utils.getAssetJsonData(context), dataType) as ResponseData)
        }
    }
}