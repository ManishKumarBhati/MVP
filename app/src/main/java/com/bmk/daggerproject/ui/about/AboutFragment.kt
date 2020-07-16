package com.bmk.daggerproject.ui.about

import android.os.Bundle
import android.view.View
import com.bmk.daggerproject.R
import com.bmk.daggerproject.util.CommonFragment
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

/**
 * Created by manish on 07/02/2018.
 */
class AboutFragment : CommonFragment(), AboutContract {

    @Inject
    lateinit var presenter: AboutPresenter


    override fun getLayout() = R.layout.fragment_about


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

    override fun loadMessageSuccess(message: String) {
        aboutText.text = getString(R.string.about_text)
        aboutText.visibility = View.VISIBLE
    }

    private fun initView() {
        presenter.loadMessage()
    }

    companion object {
        val TAG: String = "AboutFragment"
        fun newInstance(): AboutFragment {
            return AboutFragment()
        }
    }
}