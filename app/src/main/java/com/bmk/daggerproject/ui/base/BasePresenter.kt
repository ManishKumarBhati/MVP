package com.bmk.daggerproject.ui.base

import androidx.annotation.CallSuper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

abstract class BasePresenter<out T : BaseContract.View> constructor(@JvmField protected val view: T) {
    @JvmField
    protected val disposable: CompositeDisposable = CompositeDisposable()

    abstract fun start()

    @CallSuper
    open fun stop() {
        disposable.clear()
    }
}