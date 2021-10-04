package com.example.popularlibraries.presenter.users.recycler

import com.example.popularlibraries.domain.user.GithubUserModel

interface ItemView {
    var pos: Int
}

interface UserItemView : ItemView {
    fun setLogin(user: GithubUserModel)
    fun loadAvatar(user: GithubUserModel)
}