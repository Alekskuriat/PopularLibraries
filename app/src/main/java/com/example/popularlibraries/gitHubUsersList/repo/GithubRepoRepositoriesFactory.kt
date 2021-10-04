package com.example.popularlibraries.gitHubUsersList.repo

import com.example.popularlibraries.dataSource.GithubUserRepoDataSourceFactory

object GithubRepoRepositoriesFactory {
    fun create(): GithubRepoRepositories = GithubRepoRepositoriesImpl(
        GithubUserRepoDataSourceFactory.create(),
    )
}