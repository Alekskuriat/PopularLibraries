package com.example.popularlibraries.domain.repositories.data

import com.example.popularlibraries.domain.repositories.GithubRepositories
import io.reactivex.rxjava3.core.Single

interface GithubUserRepoDataSource {

    fun getRepositories (uri: String) : Single<List<GithubRepositories>>
}