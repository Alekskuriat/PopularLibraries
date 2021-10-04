package com.example.popularlibraries.view.repositories

import com.example.popularlibraries.domain.repositories.GithubRepositories
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface RepositoriesView : MvpView {

    fun showRepositories(list: List<GithubRepositories>)

    fun showError(throwable: Throwable)
}