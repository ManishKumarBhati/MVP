package com.bmk.daggerproject.ui.base

/**
 * Created by manish on 07/07/201820.
 */
class BaseContract {

    interface Presenter<in T> {
        fun start()
        fun stop()
        fun attach(view: T)
    }

    interface View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String?)
    }
}