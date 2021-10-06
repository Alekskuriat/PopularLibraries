package com.example.popularlibraries.domain.user.cache

import android.content.Context
import com.example.popularlibraries.domain.storage.GithubStorageFactory

object CacheUserDataSourceFactory {

    fun create(context: Context): CacheUserDataSource =
        CacheUserDataSourceImpl(
            GithubStorageFactory.createInMemory(context)
        )

}