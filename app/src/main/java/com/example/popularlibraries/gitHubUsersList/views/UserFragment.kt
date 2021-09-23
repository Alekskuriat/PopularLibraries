package com.example.popularlibraries.gitHubUsersList.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.popularlibraries.BackButtonListener
import com.example.popularlibraries.R
import com.example.popularlibraries.UserView
import com.example.popularlibraries.databinding.FragmentUserBinding
import com.example.popularlibraries.gitHubUsersList.model.GithubUsersRepo
import com.example.popularlibraries.gitHubUsersList.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView, BackButtonListener {

    companion object {
        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments("login" to userId)
    }


    private var viewBinding: FragmentUserBinding? = null

    private val userLogin: String by lazy {
        arguments?.getString("login").orEmpty()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin,
            GithubUsersRepo()
        )
    }


    override fun showNameUser(nameUser: String) {
        viewBinding?.userName?.text = nameUser
    }

    override fun backPressed() = presenter.backPressed()



}


private fun UserFragment.arguments(pair: Pair<String, String>): Fragment {
    this.arguments = bundleOf(pair)
    return this
}
