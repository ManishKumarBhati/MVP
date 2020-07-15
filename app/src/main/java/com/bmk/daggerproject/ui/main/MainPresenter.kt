package com.bmk.daggerproject.ui.main

import com.bmk.daggerproject.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by manish on 07/07/201820.
 */
class MainPresenter @Inject constructor(view: MainContract) : BasePresenter<MainContract>(view) {

    override fun start() {

        view.showListFragment()
    }


    fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }
}