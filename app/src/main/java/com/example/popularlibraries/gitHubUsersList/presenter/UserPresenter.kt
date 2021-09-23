package com.example.popularlibraries.gitHubUsersList.presenter

import com.example.popularlibraries.UserView
import com.example.popularlibraries.gitHubUsersList.model.GithubUsersRepo
import moxy.MvpPresenter

class UserPresenter(
    private val userName: String,
    private val usersRepo: GithubUsersRepo
    ) : MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        usersRepo.getUserById(userName).let {
            viewState.showNameUser(userName)
        }
    }

    fun backPressed(): Boolean {
        App.instance.router.newRootChain(AndroidScreens().users())
        return true
    }

}
