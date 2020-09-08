package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.domain.MatchRepository
import com.bmk.daggerproject.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by manish on 07/07/201820.
 */
class ListPresenter @Inject constructor(
    view: ListContract,
    private val repository: MatchRepository
) :
    BasePresenter<ListContract>(view) {

    override fun start() {
        repository.getTeam()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.showProgress(false)
                view.loadDataSuccess(response)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            }).addTo(disposable)

        view.onItemCLick()
            .subscribe { view.openPlayersScreen(it) }
            .addTo(disposable)
    }
}