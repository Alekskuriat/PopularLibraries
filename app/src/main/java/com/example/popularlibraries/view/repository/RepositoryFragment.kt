package com.example.popularlibraries.view.repository

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentRepositoryBinding
import com.example.popularlibraries.domain.App
import com.example.popularlibraries.domain.abs.AbsFragment
import com.example.popularlibraries.presenter.repository.RepositoryPresenter
import com.example.popularlibraries.presenter.repository.RepositoryPresenterFactory
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class RepositoryFragment : AbsFragment(R.layout.fragment_repository), RepositoryView {

    private var forks: Int = 0

    @Inject
    lateinit var repositoryPresenterFactory: RepositoryPresenterFactory

    companion object {
        private const val KEY = "forks"
        fun newInstance(forks: Int): Fragment =
            RepositoryFragment()
                .arguments(KEY to forks)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            forks = it.getInt(KEY)
        }
        super.onCreate(savedInstanceState)
    }


    private val viewBinding: FragmentRepositoryBinding by viewBinding(
        FragmentRepositoryBinding::bind
    )


    private val presenter: RepositoryPresenter by moxyPresenter {
        repositoryPresenterFactory.create(forks)
    }

    override fun showRepositoryInfo(forks: Int) {
        viewBinding.also {
            it.progress.visibility = View.GONE
            it.forks.text = forks.toString()
        }
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        viewBinding.progress.visibility = View.VISIBLE
    }
}

private fun RepositoryFragment.arguments(pair: Pair<String, Int>): Fragment {
    this.arguments = bundleOf(pair)
    return this
}