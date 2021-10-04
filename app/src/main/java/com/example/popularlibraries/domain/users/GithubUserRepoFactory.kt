package com.example.popularlibraries.domain.users

import com.example.popularlibraries.domain.user.data.GithubUserDataSourceFactory

object GithubUserRepoFactory {
    fun create(): GithubUsersRepo = GithubUsersRepoImpl(
        GithubUserDataSourceFactory.create(),
    )
}