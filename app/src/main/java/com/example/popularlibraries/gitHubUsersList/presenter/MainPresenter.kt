package com.example.popularlibraries.gitHubUsersList.presenter

import com.example.popularlibraries.IUserListPresenter
import com.example.popularlibraries.MainView
import com.example.popularlibraries.UserItemView
import com.example.popularlibraries.gitHubUsersList.GithubUser
import com.example.popularlibraries.gitHubUsersList.GithubUsersRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}

