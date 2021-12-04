package com.example.popularlibraries.view.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentUsersBinding
import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.abs.AbsFragment
import com.example.popularlibraries.view.BackButtonListener
import com.example.popularlibraries.presenter.users.recycler.UserClickListener
import com.example.popularlibraries.domain.glide.GlideImageLoader
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.presenter.users.UsersPresenter
import com.example.popularlibraries.presenter.users.recycler.UsersRVAdapter


import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UsersFragment : AbsFragment(R.layout.fragment_users), UsersView, BackButtonListener,
    UserClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    @Inject
    lateinit var githubUserRepo: GithubUsersRepo

    private val viewBinding: FragmentUsersBinding by viewBinding()

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            githubUserRepo,
            router,
            schedulers
        )
    }

    var adapter: UsersRVAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewBinding.also {
            it.rvUsers.let { rv ->
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