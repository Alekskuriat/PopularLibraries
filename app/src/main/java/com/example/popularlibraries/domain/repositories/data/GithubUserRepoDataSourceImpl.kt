package com.example.popularlibraries.domain.repositories.data

import com.example.popularlibraries.domain.api.GithubApi
import com.example.popularlibraries.domain.repositories.GithubRepositories
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUserRepoDataSourceImpl
@Inject constructor(
    private val githubApi: GithubApi
) : GithubUserRepoDataSource {

    override fun getRepositories(url: String): Single<List<GithubRepositories>> {
        return githubApi.getRepositories(url)
    }
}