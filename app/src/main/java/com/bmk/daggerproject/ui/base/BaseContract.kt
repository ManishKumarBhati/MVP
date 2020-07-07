package com.bmk.daggerproject.ui.base

/**
 * Created by ogulcan on 07/02/2018.
 */
class BaseContract {

    interface Presenter<in T> {
        fun start()
        fun stop()
        fun attach(view: T)
    }
    interface View {
    }
}