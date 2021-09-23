package com.example.popularlibraries.gitHubUsersList.presenter

import android.app.AlertDialog
import android.widget.Toast
import com.example.popularlibraries.IUserListPresenter
import com.example.popularlibraries.UserItemView
import com.example.popularlibraries.UserView
import com.example.popularlibraries.gitHubUsersList.GithubUser
import com.example.popularlibraries.gitHubUsersList.GithubUsersRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UserView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

       /*usersListPresenter.itemClickListener = { itemView ->
           router.navigateTo()
        }*/
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}
