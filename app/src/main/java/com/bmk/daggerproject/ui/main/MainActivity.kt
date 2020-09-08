package com.bmk.daggerproject.ui.main

import android.os.Bundle

import com.bmk.daggerproject.R
import com.bmk.daggerproject.ui.list.TeamFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by manish on 07/07/201820.
 */
class MainActivity : DaggerAppCompatActivity(), MainContract {


    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(
                AnimType.SLIDE.getAnimPair().first,
                AnimType.SLIDE.getAnimPair().second
            )
            .replace(R.id.frame, TeamFragment.newInstance(), TeamFragment.TAG)
            .commit()
    }

    override fun onBackPressed() {
        supportFragmentManager.popBackStack()
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