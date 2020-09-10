package com.bmk.daggerproject.ui.about

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmk.daggerproject.R
import com.bmk.daggerproject.domain.PlayersInfo
import com.bmk.daggerproject.domain.TeamInfo
import com.bmk.daggerproject.util.CommonFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_player.*
import org.json.JSONObject
import java.lang.reflect.Type
import javax.inject.Inject

/**
 * Created by manish on 07/02/2018.
 */
class PlayerFragment : CommonFragment(), PlayerContract {

    @Inject
    lateinit var presenter: PlayerPresenter


    override fun getLayout() = R.layout.fragment_player

    @Inject
    lateinit var gson: Gson
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.stop()
    }

    override fun showProgress(show: Boolean) {
        if (show) {

            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun loadMessageSuccess(data: Pair<String, String>) {
        val section = Section()
        rv_players_list?.let {
            it.apply {
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
                adapter = GroupAdapter<ViewHolder>().apply { add(section) }
            }
        }
        section.update(emptyList())
        val obj = JSONObject(data.first)
        val team = obj.getJSONObject("Teams")
        val teamKeys = team.keys()
        val teamList: MutableList<JSONObject> = mutableListOf()
        val teamListData: MutableList<JSONObject> = mutableListOf()
        val playersListData: MutableList<PlayersInfo> = mutableListOf()

        while (teamKeys.hasNext()) {
            teamList.add(team.getJSONObject(teamKeys.next()))
        }

        teamList.forEach {
            val dataType: Type = object : TypeToken<TeamInfo>() {}.type
            val info = gson.fromJson(it.toString(), dataType) as TeamInfo
            if (info.nameFull.equals(data.second, true)) teamListData.add(it)
        }
        teamListData.forEach {
            val players = it.getJSONObject("Players")
            val playersKey = players.keys()
            while (playersKey.hasNext()) {
                val dataType: Type = object : TypeToken<PlayersInfo>() {}.type
                val info = gson.fromJson(
                    players.getJSONObject(playersKey.next()).toString(),
                    dataType
                ) as PlayersInfo

                playersListData.add(info)
            }
        }
        val item = playersListData.map {
            PlayersItem(it)
        }
        section.update(item)

    }

    override fun showErrorMessage(error: String?) {
        Log.e("Error", error)
    }

    private fun initView() {
        presenter.loadMessage()
    }

    companion object {
        val TAG: String = "AboutFragment"
        val ARGS_PLAYER: String = "AboutFragment"
        fun newInstance(teamName: String): PlayerFragment {
            return PlayerFragment().apply {
                arguments = bundleOf(ARGS_PLAYER to teamName)
            }
        }
    }
}