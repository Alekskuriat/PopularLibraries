package com.example.popularlibraries.gitHubUsersList.presenter

import com.example.popularlibraries.IUserListPresenter
import com.example.popularlibraries.UserItemView
import com.example.popularlibraries.UsersView
import com.example.popularlibraries.gitHubUsersList.model.GithubUser
import com.example.popularlibraries.gitHubUsersList.model.GithubUsersRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router
    ) : MvpPresenter<UsersView>() {

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

      usersListPresenter.itemClickListener = {
           router
               .navigateTo(AndroidScreens()
                   .user(usersRepo.getUsers()[it.pos].login))
        }

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
