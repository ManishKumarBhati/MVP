package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.ui.base.BaseContract

/**
 * Created by ogulcan on 07/02/2018.
 */
interface AboutContract :BaseContract.View{
    fun showProgress(show: Boolean)
    fun loadMessageSuccess(message: String)
}