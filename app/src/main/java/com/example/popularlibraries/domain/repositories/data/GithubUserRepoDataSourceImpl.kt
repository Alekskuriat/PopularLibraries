package com.example.popularlibraries.domain.repositories.data

import com.example.popularlibraries.domain.api.GithubApi
import com.example.popularlibraries.domain.repositories.GithubRepositories
import io.reactivex.rxjava3.core.Single

class GithubUserRepoDataSourceImpl(
    private val githubApi: GithubApi,
    private val url : String
) : GithubUserRepoDataSource {

    override fun getRepositories(): Single<List<GithubRepositories>> {
        return githubApi.getRepositories(url)
    }
}