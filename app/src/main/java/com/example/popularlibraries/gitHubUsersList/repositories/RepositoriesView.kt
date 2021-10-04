package com.example.popularlibraries.gitHubUsersList.repositories

import com.example.popularlibraries.gitHubUsersList.repo.GithubRepositories
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface RepositoriesView : MvpView {

    fun showRepositories(list: List<GithubRepositories>)

    fun showError(throwable: Throwable)
}