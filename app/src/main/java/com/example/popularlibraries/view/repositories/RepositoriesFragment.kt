package com.example.popularlibraries.view.repositories

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentRepositoriesBinding
import com.example.popularlibraries.domain.App
import com.example.popularlibraries.view.BackButtonListener
import com.example.popularlibraries.domain.repositories.GithubRepoRepositoriesFactory
import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.presenter.repositories.recycler.RepositoriesAdapter
import com.example.popularlibraries.presenter.repositories.RepositoriesPresenter
import com.example.popularlibraries.view.viewBinding

import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoriesFragment : MvpAppCompatFragment(R.layout.fragment_repositories), RepositoriesView,
    BackButtonListener, RepositoriesAdapter.RepoClickListener {

    private var url: String? = null
    var adapter: RepositoriesAdapter? = null

    companion object {
        private const val KEY = "repo"
        fun newInstance(url: String): Fragment =
            RepositoriesFragment()
                .arguments(KEY to url)
    }

    private val viewBinding: FragmentRepositoriesBinding by viewBinding(
        FragmentRepositoriesBinding::bind
    )

    private val presenter: RepositoriesPresenter by moxyPresenter {
        RepositoriesPresenter(
            GithubRepoRepositoriesFactory.create(),
            url,
            App.instance.router
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            url = it.getString(KEY)
        }

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.also {
            it.repositories.let {rv ->
                rv.layoutManager = LinearLayoutManager(context)
                adapter = RepositoriesAdapter(this)
                rv.adapter = adapter
            }
        }
    }

    override fun backPressed(): Boolean = presenter.backPressed()


    override fun onClickRepo(repo: GithubRepositories) {

    }

    override fun showRepositories(list: List<GithubRepositories>) {
        adapter?.submit(list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }


}

private fun RepositoriesFragment.arguments(pair: Pair<String, String>): Fragment {
    this.arguments = bundleOf(pair)
    return this
}