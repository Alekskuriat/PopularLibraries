package com.example.popularlibraries.gitHubUsersList.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import com.example.popularlibraries.gitHubUsersList.App
import com.example.popularlibraries.gitHubUsersList.BackButtonListener
import com.example.popularlibraries.gitHubUsersList.user.UserClickListener
import com.example.popularlibraries.viewBinding
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
            GithubUsersRepo(),
            App.instance.router
        )
    }

    var adapter: UsersRVAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(this)
        viewBinding.rvUsers.adapter = adapter
    }


    override fun showUsers(list: List<GithubUserModel>) {
        adapter?.submit(list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickUser(user: GithubUserModel) {
        presenter.openUserInfo(user)
    }

    override fun backPressed() = presenter.backPressed()
}