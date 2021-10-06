package com.example.popularlibraries.domain.repositories

import com.example.popularlibraries.domain.repositories.cache.CacheUserRepoDataSource
import com.example.popularlibraries.domain.repositories.cache.CacheUserRepoDataSourceImpl
import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoriesImpl(
    private val gitHubReposDataSource: GithubUserRepoDataSource,
    private val cache : CacheUserRepoDataSource
) : GithubRepoRepositories {

    override fun getRepositories(): Observable<List<GithubRepositories>> =
        Observable.merge(
            cache.getRepositories().toObservable(),
            gitHubReposDataSource.getRepositories().flatMap (cache::retain).toObservable()
        )



}