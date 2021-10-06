package com.example.popularlibraries.domain.repositories

import android.content.Context
import com.example.popularlibraries.domain.repositories.cache.CacheUserRepoDataSourceFactory
import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSourceFactory
import com.example.popularlibraries.domain.user.cache.CacheUserDataSourceFactory
import com.example.popularlibraries.domain.user.data.GithubUserDataSourceFactory
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.domain.users.GithubUsersRepoImpl

object GithubRepoRepositoriesFactory {


    fun create(): GithubRepoRepositories = GithubRepoRepositoriesImpl(
        GithubUserRepoDataSourceFactory.create(),
    )

    fun create(context : Context): GithubRepoRepositories {
        return GithubRepoRepositoriesImpl(
            GithubUserRepoDataSourceFactory.create(),
            CacheUserRepoDataSourceFactory.create(context)
        )
    }
}