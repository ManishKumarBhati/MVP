package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.api.ApiServiceInterface
import com.bmk.daggerproject.models.Album
import com.bmk.daggerproject.models.DetailsViewModel
import com.bmk.daggerproject.models.Post
import com.bmk.daggerproject.models.User
import com.bmk.daggerproject.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by manish on 07/07/201820.
 */
class ListPresenter @Inject constructor(val api: ApiServiceInterface, view: ListContract) :
    BasePresenter<ListContract>(view) {

    override fun start() {
        api.getPostList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Post>? ->
                view.showProgress(false)
                view.loadDataSuccess(list!!.take(10))
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            }).addTo(disposable)
    }

}