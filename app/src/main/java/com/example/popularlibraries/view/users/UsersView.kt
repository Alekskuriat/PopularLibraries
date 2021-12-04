package com.example.popularlibraries.view.users

import com.example.popularlibraries.domain.user.GithubUserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface UsersView : MvpView {

    fun showUsers(list: List<GithubUserModel>)

    fun showError(throwable: Throwable)

    fun showLoading()
}
