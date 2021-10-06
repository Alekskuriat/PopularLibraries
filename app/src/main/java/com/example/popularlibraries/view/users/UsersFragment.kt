package com.example.popularlibraries.view.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.users.GithubUserRepoFactory
import com.example.popularlibraries.domain.App
import com.example.popularlibraries.view.BackButtonListener
import com.example.popularlibraries.presenter.users.recycler.UserClickListener
import com.example.popularlibraries.domain.glide.GlideImageLoader
import com.example.popularlibraries.presenter.users.UsersPresenter
import com.example.popularlibraries.presenter.users.recycler.UsersRVAdapter
import com.example.popularlibraries.view.viewBinding


import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener,
    UserClickListener {


    companion object {
        fun newInstance() = UsersFragment()
    }

    private val viewBinding: FragmentUsersBinding by viewBinding(
        FragmentUsersBinding::bind
    )

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUserRepoFactory.create(requireContext()),
            App.instance.router
        )
    }

    var adapter: UsersRVAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewBinding.also {
            it.rvUsers.let {rv ->
                rv.layoutManager = LinearLayoutManager(context)
                adapter = UsersRVAdapter(this, GlideImageLoader())
                rv.adapter = adapter
            }
        }

    }


    override fun showUsers(list: List<GithubUserModel>) {
        viewBinding.progress.visibility = View.GONE
        adapter?.submit(list)
            ?: Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        viewBinding.progress.visibility = View.VISIBLE

    }

    override fun onClickUser(user: GithubUserModel) {
        presenter.openUserInfo(user)
    }

    override fun backPressed() = presenter.backPressed()
}