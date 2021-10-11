package com.example.popularlibraries.domain.repositories.cache

import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.domain.storage.GithubStorage
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheUserRepoDataSourceImpl
@Inject constructor(
    private val githubStorage: GithubStorage
) : CacheUserRepoDataSource {


    override fun retain(
        repositories: List<GithubRepositories>,
        url: String
    ): Single<List<GithubRepositories>> =
        githubStorage
            .getGithubUserRepoDao()
            .retain(repositories)
            .andThen(getRepositories(url))


    override fun getRepositories(url: String): Single<List<GithubRepositories>> =
        githubStorage
            .getGithubUserRepoDao()
            .getRepositories()


}
