package com.bmk.daggerproject.ui.main

import android.os.Bundle
import com.bmk.daggerproject.R
import com.bmk.daggerproject.ui.about.PlayerFragment
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by manish on 07/07/201820.
 */
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
    }

    private fun setView() {
        showListFragment()
    }

    /*  override fun showProgress(show: Boolean) {
          progressBar.visibility = if (show) View.VISIBLE else View.GONE
      }

      override fun showErrorMessage(error: String) {
          Log.e("Error", error)
      }*/

    fun showListFragment() {
        if (supportFragmentManager.findFragmentByTag(PlayerFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(
                    AnimType.FADE.getAnimPair().first,
                    AnimType.FADE.getAnimPair().second
                )
                .replace(R.id.frame, PlayerFragment.newInstance(), PlayerFragment.TAG)
                .commit()
        }
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