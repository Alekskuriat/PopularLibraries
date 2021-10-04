package com.example.popularlibraries.presenter.users.recycler

import com.example.popularlibraries.domain.user.GithubUserModel

interface UserClickListener {
    fun onClickUser(user: GithubUserModel)
}