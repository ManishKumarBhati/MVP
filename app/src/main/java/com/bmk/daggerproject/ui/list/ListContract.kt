package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.domain.TeamInfo
import com.bmk.daggerproject.ui.base.BaseContract
import io.reactivex.Observable

/**
 * Created by manish on 07/02/2018.
 */
interface ListContract : BaseContract.View {
    fun showProgress(show: Boolean)
    fun showErrorMessage(error: String?)
    fun loadDataSuccess(data: String)
    fun onItemCLick(): Observable<TeamInfo>
    fun openPlayersScreen(info: TeamInfo)
}