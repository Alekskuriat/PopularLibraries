package com.example.popularlibraries.domain.repositories

import android.content.Context
import com.example.popularlibraries.domain.repositories.cache.CacheUserRepoDataSourceFactory
import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSourceFactory
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.domain.users.GithubUsersRepoImpl

object GithubRepoRepositoriesFactory {



    fun create(context: Context, url: String): GithubRepoRepositories {
        return GithubRepoRepositoriesImpl(
            GithubUserRepoDataSourceFactory.create(url),
            CacheUserRepoDataSourceFactory.create(context)
        )
    }
}