package com.bmk.daggerproject.ui.about

import com.bmk.daggerproject.domain.MatchRepository
import com.bmk.daggerproject.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by manish on 07/07/201820.
 */
class PlayerPresenter @Inject constructor(
    view: PlayerContract,
    val teamName: String?,
    val repository: MatchRepository
) :
    BasePresenter<PlayerContract>(view) {
    override fun start() {
        loadMessage()
    }

    fun loadMessage() {
        // Wait for a moment
        repository.getTeam()
            .filter { teamName != null }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.showProgress(false)
                view.loadMessageSuccess(response to teamName!!)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            }).addTo(disposable)
    }
}