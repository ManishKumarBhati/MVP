package com.bmk.daggerproject.domain
import io.reactivex.Observable

interface MatchRepository {
    fun getMatchData(): Observable<ResponseData>
}