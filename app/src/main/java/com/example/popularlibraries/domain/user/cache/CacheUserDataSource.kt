package com.example.popularlibraries.domain.user.cache

import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.user.data.GithubUserDataSource
import io.reactivex.rxjava3.core.Single

interface CacheUserDataSource : GithubUserDataSource {

    fun retain(users: List<GithubUserModel>): Single<List<GithubUserModel>>

}