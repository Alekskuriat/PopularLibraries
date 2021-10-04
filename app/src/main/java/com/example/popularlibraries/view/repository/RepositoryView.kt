package com.example.popularlibraries.view.repository

import com.example.popularlibraries.domain.repositories.GithubRepositories
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface RepositoryView : MvpView {

    fun showRepositoryInfo(forks : Int)

    fun showError(throwable: Throwable)

    fun showLoading()
}