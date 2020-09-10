package com.bmk.daggerproject.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible

import com.bmk.daggerproject.R
import com.bmk.daggerproject.domain.TeamInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.lang.reflect.Type
import javax.inject.Inject

/**
 * Created by manish on 07/07/201820.
 */
class MainActivity : DaggerAppCompatActivity(), MainContract {
    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        presenter.start()
    }

    private fun setView() {

    }

    override fun showProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showErrorMessage(error: String?) {
        Log.e("Error", error)
    }

    override fun showListFragment(data: String) {
        val obj = JSONObject(data)
        val team = obj.getJSONObject("Teams")
        val teamKeys = team.keys()
        val teamList: MutableList<JSONObject> = mutableListOf()
        val teamListData: MutableList<TeamInfo> = mutableListOf()

        while (teamKeys.hasNext()) {
            teamList.add(team.getJSONObject(teamKeys.next()))
        }

        teamList.forEach {
            val dataType: Type = object : TypeToken<TeamInfo>() {}.type
            val info = gson.fromJson(it.toString(), dataType) as TeamInfo
            teamListData.add(info)
        }

        val adapter = PagerAdapter(supportFragmentManager, teamListData)
        tv_header.isVisible = true
        vp_team.adapter = adapter
        tl_team.setupWithViewPager(vp_team)

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