package com.example.popularlibraries.domain.users

import android.content.Context
import com.example.popularlibraries.domain.user.cache.CacheUserDataSource
import com.example.popularlibraries.domain.user.cache.CacheUserDataSourceFactory
import com.example.popularlibraries.domain.user.data.GithubUserDataSourceFactory
import com.example.popularlibraries.domain.user.data.GithubUserDataSourceImpl

object GithubUserRepoFactory {

    fun create(context : Context): GithubUsersRepo {
        return GithubUsersRepoImpl(
            GithubUserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create(context)
        )
    }

}