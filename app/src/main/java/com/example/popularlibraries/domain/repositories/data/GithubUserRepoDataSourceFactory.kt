package com.example.popularlibraries.domain.repositories.data

import com.example.popularlibraries.domain.api.GithubApiFactory

object GithubUserRepoDataSourceFactory {

    fun create(url : String): GithubUserRepoDataSource = GithubUserRepoDataSourceImpl(GithubApiFactory.create(), url)

}