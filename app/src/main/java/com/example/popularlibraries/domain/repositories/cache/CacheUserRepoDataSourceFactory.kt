package com.example.popularlibraries.domain.repositories.cache

import android.content.Context
import com.example.popularlibraries.domain.storage.GithubStorageFactory
import com.example.popularlibraries.domain.user.cache.CacheUserDataSource
import com.example.popularlibraries.domain.user.cache.CacheUserDataSourceImpl

object CacheUserRepoDataSourceFactory {

    fun create(context: Context): CacheUserRepoDataSource =
        CacheUserRepoDataSourceImpl(
            GithubStorageFactory.createInMemory(context)
        )

}