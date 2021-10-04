package com.example.popularlibraries.dataSource

import com.example.popularlibraries.api.GithubApi
import com.example.popularlibraries.gitHubUsersList.repo.GithubRepositories
import io.reactivex.rxjava3.core.Single

class GithubUserRepoDataSourceImpl(
    private val githubApi: GithubApi
) : GithubUserRepoDataSource {
    override fun getRepositories(uri: String): Single<List<GithubRepositories>> {
        return githubApi.getRepositories(uri)
    }
}