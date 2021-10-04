package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel

interface ItemView {
    var pos: Int
}

interface UserItemView : ItemView {
    fun setLogin(user: GithubUserModel)
    fun loadAvatar(user: GithubUserModel)
}