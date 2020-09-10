package com.bmk.daggerproject.ui.main

import com.bmk.daggerproject.ui.base.BaseContract

/**
 * Created by manish on 07/07/201820.
 */
interface MainContract : BaseContract.View {
    fun showListFragment(data: String)
    fun showProgress(show: Boolean)
    fun showErrorMessage(error: String?)
}
