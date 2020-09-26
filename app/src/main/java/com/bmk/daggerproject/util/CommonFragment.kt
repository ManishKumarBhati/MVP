package com.bmk.daggerproject.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

abstract class CommonFragment : DaggerFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    @LayoutRes
    abstract fun getLayout(): Int

    /*protected fun toggleProgress(isVisible: Boolean) {
        navigator.showProgress(isVisible)
    }
    fun showError(error:String?){
        navigator.showErrorMessage(error ?:"Opps Some thing went wrong!")
    }*/

}