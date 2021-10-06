package com.example.popularlibraries.domain.repositories.cache

import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.domain.storage.GithubStorage
import io.reactivex.rxjava3.core.Single

class CacheUserRepoDataSourceImpl(
    private val githubStorage: GithubStorage
) : CacheUserRepoDataSource {


    override fun retain(
        repositories: List<GithubRepositories>
    ): Single<List<GithubRepositories>> =
        githubStorage
            .getGithubUserRepoDao()
            .retain(repositories)
            .andThen(getRepositories())


    override fun getRepositories(): Single<List<GithubRepositories>> =
        githubStorage
            .getGithubUserRepoDao()
            .getRepositories()


}
