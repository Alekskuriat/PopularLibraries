package com.example.popularlibraries.gitHubUsersList.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.BackButtonListener
import com.example.popularlibraries.UsersView
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.gitHubUsersList.model.GithubUsersRepo
import com.example.popularlibraries.gitHubUsersList.presenter.App
import com.example.popularlibraries.gitHubUsersList.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(),
            App.instance.router
        )
    }
    var adapter: UsersRVAdapter? = null

    private var viewBinding: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun init() {
        viewBinding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        viewBinding?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}