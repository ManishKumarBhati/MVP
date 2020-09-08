package com.bmk.daggerproject.domain

import io.reactivex.Single

interface MatchRepository {
    fun getMatchData(): Single<String>
    fun getTeam(): Single<String>
}