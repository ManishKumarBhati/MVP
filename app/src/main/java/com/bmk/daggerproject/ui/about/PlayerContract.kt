package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.ui.base.BaseContract

/**
 * Created by manish on 07/07/201820.
 */
interface PlayerContract : BaseContract.View {
    fun showProgress(show: Boolean)
    fun loadMessageSuccess(data: Pair<String, String>)
    fun showErrorMessage(error: String?)
}