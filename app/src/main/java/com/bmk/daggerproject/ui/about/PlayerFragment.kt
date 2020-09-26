package com.bmk.daggerproject.ui.about

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.bmk.daggerproject.R
import com.bmk.daggerproject.domain.ResponseData
import com.bmk.daggerproject.util.CommonFragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_player.*
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
        progressBar.isVisible = show
    }

    override fun loadMessageSuccess(data: ResponseData) {
        /*val section = Section()
        rv_players_list?.let {
            it.apply {
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
                adapter = GroupAdapter<ViewHolder>().apply { add(section) }
            }
        }
       section.update()*/
        Log.d("bmk", data.toString())

    }

    override fun showErrorMessage(error: String?) {
        Log.e("Error", error)
    }

    private fun initView() {
        presenter.loadMessage()
    }

    companion object {
        val TAG: String = "PlayerFragment"
        fun newInstance(): PlayerFragment {
            return PlayerFragment()
        }
    }
}