package com.bmk.daggerproject.ui.list

import com.bmk.daggerproject.domain.ResponseData
import com.bmk.daggerproject.ui.base.BaseContract

/**
 * Created by manish on 07/07/201820.
 */
interface ListContract : BaseContract.View {
    fun loadMessageSuccess(data: ResponseData)
}