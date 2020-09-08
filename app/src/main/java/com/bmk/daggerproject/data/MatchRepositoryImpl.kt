package com.bmk.daggerproject.data

import com.bmk.daggerproject.api.ApiServiceInterface
import com.bmk.daggerproject.data.db.MatchData
import com.bmk.daggerproject.data.db.MatchDataBase
import com.bmk.daggerproject.domain.MatchRepository
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    val api: ApiServiceInterface,
    val db: MatchDataBase,
    val gson: Gson
) :
    MatchRepository {
    override fun getMatchData(): Single<String> {
        return api.getPostList().map {
            addMatchData(it)
            "success"
        }
    }

    override fun getTeam(): Single<String> {
        return getMatchLocalData()
    }

    private fun addMatchData(data: String) {
        db.matchDOA().insertAll(MatchData(data))
    }

    private fun getMatchLocalData(): Single<String> {
        return db.matchDOA().getAlData()
    }
}