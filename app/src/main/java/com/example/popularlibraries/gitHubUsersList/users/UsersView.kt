package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface UsersView : MvpView {

    fun showUsers(list: List<GithubUserModel>)

    fun showError(throwable: Throwable)

    fun showLoading()
}
