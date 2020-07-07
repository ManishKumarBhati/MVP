package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by ogulcan on 07/02/2018.
 */
class AboutPresenter @Inject constructor(view: AboutContract) : BasePresenter<AboutContract>(view) {
    override fun start() {
        loadMessage()
    }

    fun loadMessage() {
        // Wait for a moment
        Observable.just(true).delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.showProgress(false)
                view.loadMessageSuccess("Success")
            }.addTo(disposable)
    }
}