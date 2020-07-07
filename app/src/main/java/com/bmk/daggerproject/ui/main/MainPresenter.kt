package com.bmk.daggerproject.ui.main

import com.bmk.daggerproject.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by ogulcan on 07/02/2018.
 */
class MainPresenter @Inject constructor(view: MainContract) : BasePresenter<MainContract>(view) {

    override fun start() {

        view.showListFragment()
    }


    fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }
}