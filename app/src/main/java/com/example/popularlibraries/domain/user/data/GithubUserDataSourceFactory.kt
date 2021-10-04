package com.example.popularlibraries.domain.user.data

import com.example.popularlibraries.domain.api.GithubApiFactory

object GithubUserDataSourceFactory {
    fun create(): GithubUserDataSource = GithubUserDataSourceImpl(GithubApiFactory.create())

}