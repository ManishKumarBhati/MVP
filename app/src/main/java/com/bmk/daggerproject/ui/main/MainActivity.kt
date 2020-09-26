package com.bmk.daggerproject.ui.main

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.bmk.daggerproject.R
import com.bmk.daggerproject.ui.list.ListFragment
import dagger.android.support.DaggerAppCompatActivity


/**
 * Created by manish on 07/07/201820.
 */
class MainActivity : DaggerAppCompatActivity() {
    var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
    }

    private fun setView() {
        showListFragment()
    }


    fun showListFragment() {
        if (supportFragmentManager.findFragmentByTag(ListFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(
                    AnimType.FADE.getAnimPair().first,
                    AnimType.FADE.getAnimPair().second
                )
                .add(R.id.frame, ListFragment.newInstance(), ListFragment.TAG)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish()
            return
        }

        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

    enum class AnimType() {
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int> {
            return when (this) {
                SLIDE -> Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> Pair(R.anim.fade_in, R.anim.fade_out)
            }
        }
    }
}