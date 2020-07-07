package com.bmk.daggerproject.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmk.daggerproject.R
import com.bmk.daggerproject.models.DetailsViewModel
import com.bmk.daggerproject.models.Post
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*

import javax.inject.Inject


class ListFragment : DaggerFragment(), ListContract {

    @Inject
    lateinit var presenter: ListPresenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start()

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

    override fun showErrorMessage(error: String?) {
        Log.e("Error", error)
    }

    override fun loadDataSuccess(list: List<Post>) {
        val section = Section()
        recyclerView?.let {
            it.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<ViewHolder>().apply { add(section) }
            }
        }
        section.update(emptyList())
        val item = list.map { ListItem(it) }
        section.update(item)
    }

    override fun loadDataAllSuccess(model: DetailsViewModel) {
        print(model.toJson())
    }


    companion object {
        val TAG: String = "ListFragment"
    }
}