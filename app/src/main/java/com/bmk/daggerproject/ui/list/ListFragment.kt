package com.bmk.daggerproject.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmk.daggerproject.R
import com.bmk.daggerproject.domain.TeamInfo
import com.bmk.daggerproject.util.CommonFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_list.*
import org.json.JSONObject
import java.lang.reflect.Type
import javax.inject.Inject


class ListFragment : CommonFragment(), ListContract {

    @Inject
    lateinit var presenter: ListPresenter

    @Inject
    lateinit var gson: Gson

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

        val item = teamListData.map { ListItem(it) }
        section.update(item)
    }

    companion object {
        val TAG: String = "ListFragment"
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}