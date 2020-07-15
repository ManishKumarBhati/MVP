package com.bmk.daggerproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bmk.daggerproject.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

/**
 * Created by manish on 07/02/2018.
 */
class AboutFragment : DaggerFragment(), AboutContract {

    @Inject
    lateinit var presenter: AboutPresenter

    private lateinit var rootView: View

    fun newInstance(): AboutFragment {
        return AboutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_about, container, false)
        return rootView
    }

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
    }
}