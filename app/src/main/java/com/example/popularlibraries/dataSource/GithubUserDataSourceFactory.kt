package com.example.popularlibraries.dataSource

import com.example.popularlibraries.api.GithubApiFactory

object GithubUserDataSourceFactory {
    fun create(): GithubUserDataSource = GithubUserDataSourceImpl(GithubApiFactory.create())

}