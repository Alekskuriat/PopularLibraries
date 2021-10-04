package com.example.popularlibraries.dataSource

import com.example.popularlibraries.api.GithubApiFactory

object GithubUserRepoDataSourceFactory {

    fun create(): GithubUserRepoDataSource = GithubUserRepoDataSourceImpl(GithubApiFactory.create())

}