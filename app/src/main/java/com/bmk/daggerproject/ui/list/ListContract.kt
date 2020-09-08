package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.ui.base.BaseContract

/**
 * Created by manish on 07/02/2018.
 */
interface ListContract : BaseContract.View {
    fun showProgress(show: Boolean)
    fun showErrorMessage(error: String?)
    fun loadDataSuccess(data: String)
}