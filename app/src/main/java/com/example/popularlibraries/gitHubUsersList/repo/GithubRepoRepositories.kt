package com.example.popularlibraries.gitHubUsersList.repo

import io.reactivex.rxjava3.core.Single

interface GithubRepoRepositories {
    fun getRepositories(url: String): Single<List<GithubRepositories>>
}