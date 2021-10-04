package com.example.popularlibraries.dataSource

import com.example.popularlibraries.gitHubUsersList.repo.GithubRepositories
import io.reactivex.rxjava3.core.Single

interface GithubUserRepoDataSource {

    fun getRepositories (uri: String) : Single<List<GithubRepositories>>
}