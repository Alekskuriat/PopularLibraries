package com.example.popularlibraries.domain.repositories

import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSourceFactory

object GithubRepoRepositoriesFactory {
    fun create(): GithubRepoRepositories = GithubRepoRepositoriesImpl(
        GithubUserRepoDataSourceFactory.create(),
    )
}