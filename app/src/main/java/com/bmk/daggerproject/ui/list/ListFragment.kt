package com.bmk.daggerproject.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmk.daggerproject.R
import com.bmk.daggerproject.models.DetailsViewModel
import com.bmk.daggerproject.models.Post
import com.bmk.daggerproject.util.CommonFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject


class ListFragment : CommonFragment(), ListContract {

    @Inject
    lateinit var presenter: ListPresenter


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
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}