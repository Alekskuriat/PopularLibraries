package com.example.popularlibraries.domain.repositories.cache

import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSource
import io.reactivex.rxjava3.core.Single

interface CacheUserRepoDataSource : GithubUserRepoDataSource {

    fun retain(
        repositories: List<GithubRepositories>,
        url: String
    ): Single<List<GithubRepositories>>

}