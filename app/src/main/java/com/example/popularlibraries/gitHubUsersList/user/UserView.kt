package com.example.popularlibraries.gitHubUsersList.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showNameUser(user : GithubUserModel)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)
}
