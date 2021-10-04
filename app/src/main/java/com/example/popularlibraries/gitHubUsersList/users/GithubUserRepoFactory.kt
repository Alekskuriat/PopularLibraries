package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.dataSource.GithubUserDataSourceFactory

object GithubUserRepoFactory {
    fun create(): GithubUsersRepo = GithubUsersRepoImpl(
        GithubUserDataSourceFactory.create(),
    )
}