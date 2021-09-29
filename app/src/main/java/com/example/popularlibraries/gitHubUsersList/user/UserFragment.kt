package com.example.popularlibraries.gitHubUsersList.user

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentUserBinding
import com.example.popularlibraries.gitHubUsersList.App
import com.example.popularlibraries.gitHubUsersList.BackButtonListener
import com.example.popularlibraries.gitHubUsersList.users.GithubUsersRepoImpl
import com.example.popularlibraries.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView, BackButtonListener {

    private var id: Int? = null

    private val viewBinding: FragmentUserBinding by viewBinding(
        FragmentUserBinding::bind
    )

    companion object {
        private const val KEY = "login"
        fun newInstance(userId: Int): Fragment =
            UserFragment()
                .arguments(KEY to userId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            id = it.getInt(KEY)
        }
        super.onCreate(savedInstanceState)
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userId = id,
            usersRepo = GithubUsersRepoImpl(),
            router = App.instance.router
        )
    }

    override fun backPressed() = presenter.backPressed()

    @SuppressLint("ResourceAsColor")
    override fun showNameUser(user: GithubUserModel) {

        viewBinding.apply {
            userName.run {
                text = user.login
                textSize = 30f
                setTextColor(R.color.teal_200)
            }
        }

    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }


}


private fun UserFragment.arguments(pair: Pair<String, Int>): Fragment {
    this.arguments = bundleOf(pair)
    return this
}
