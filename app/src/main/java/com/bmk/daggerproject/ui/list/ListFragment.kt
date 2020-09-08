package com.bmk.daggerproject.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmk.daggerproject.R
import com.bmk.daggerproject.domain.TeamInfo
import com.bmk.daggerproject.ui.about.AboutFragment
import com.bmk.daggerproject.ui.main.MainActivity
import com.bmk.daggerproject.util.CommonFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_list.*
import org.json.JSONObject
import java.lang.reflect.Type
import javax.inject.Inject


class ListFragment : CommonFragment(), ListContract {

    @Inject
    lateinit var presenter: ListPresenter

    @Inject
    lateinit var gson: Gson
    internal val eventSubject: PublishSubject<TeamInfo> = PublishSubject.create()

    override fun getLayout() = R.layout.fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.stop()
    }

    override fun showProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showErrorMessage(error: String?) {
        Log.e("Error", error)
    }

    override fun onItemCLick(): Observable<TeamInfo> {
        return eventSubject
    }

    override fun openPlayersScreen(info: TeamInfo) {
        activity?.let {
            if (it.supportFragmentManager.findFragmentByTag(AboutFragment.TAG) == null) {
                it.supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(
                        MainActivity.AnimType.FADE.getAnimPair().first,
                        MainActivity.AnimType.FADE.getAnimPair().second
                    )
                    .replace(R.id.frame, AboutFragment.newInstance(), AboutFragment.TAG)
                    .commit()
            }
        }
    }

    override fun loadDataSuccess(data: String) {
        val section = Section()
        recyclerView?.let {
            it.apply {
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
                adapter = GroupAdapter<ViewHolder>().apply { add(section) }
            }
        }
        section.update(emptyList())
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

        val item = teamListData.map { ListItem(it, eventSubject) }
        section.update(item)
    }

    companion object {
        val TAG: String = "ListFragment"
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}