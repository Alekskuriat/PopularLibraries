package com.example.popularlibraries.domain.repositories

import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSource
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoriesImpl(
    private val gitHubReposDataSource: GithubUserRepoDataSource
) : GithubRepoRepositories {
    override fun getRepositories(url: String): Single<List<GithubRepositories>> {
        return gitHubReposDataSource.getRepositories(url)
    }

}