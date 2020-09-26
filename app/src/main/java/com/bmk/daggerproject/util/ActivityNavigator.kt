package com.bmk.daggerproject.util

interface ActivityNavigator {
    fun showProgress(show: Boolean)
    fun showErrorMessage(error: String)
}