package com.bmk.daggerproject.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.bmk.daggerproject.R
import com.bmk.daggerproject.domain.ResponseData
import com.bmk.daggerproject.util.CommonFragment
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_player.*
import javax.inject.Inject

/**
 * Created by manish on 07/02/2018.
 */
class ListFragment : CommonFragment(), ListContract {

    @Inject
    lateinit var presenter: ListPresenter


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
        progressBar.isVisible = show
    }

    override fun loadMessageSuccess(data: ResponseData) {
        val section = Section()
        rv_players_list?.let {
            it.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = GroupAdapter<ViewHolder>().apply { add(section) }
            }
        }
        val item = data.results.map {
            ListItem(it)
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
        val TAG: String = "ListFragment"
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}