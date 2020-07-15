package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.ui.base.BaseContract
import com.bmk.daggerproject.models.DetailsViewModel
import com.bmk.daggerproject.models.Post

/**
 * Created by manish on 07/02/2018.
 */
interface ListContract : BaseContract.View {
    fun showProgress(show: Boolean)
    fun showErrorMessage(error: String?)
    fun loadDataSuccess(list: List<Post>)
    fun loadDataAllSuccess(model: DetailsViewModel)
}