package com.example.popularlibraries.domain.user.cache

import com.example.popularlibraries.domain.storage.GithubStorage
import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheUserDataSourceImpl
@Inject constructor(
    private val githubStorage: GithubStorage
) : CacheUserDataSource {

    override fun retain(users: List<GithubUserModel>): Single<List<GithubUserModel>> =
        githubStorage
            .getGithubUserDao()
            .retain(users)
            .andThen(getUsers())

    override fun getUsers(): Single<List<GithubUserModel>> =
        githubStorage
            .getGithubUserDao()
            .getGithubUsers()


}