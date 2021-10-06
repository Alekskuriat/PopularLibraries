package com.example.popularlibraries.domain.users

import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.user.cache.CacheUserDataSource
import com.example.popularlibraries.domain.user.data.GithubUserDataSource
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.security.PrivateKey

class GithubUsersRepoImpl(
    private val githubUserDataSource: GithubUserDataSource,
    private val cache : CacheUserDataSource
) : GithubUsersRepo {



    override fun getUsers(): Observable<List<GithubUserModel>> =
        Observable.merge(
            cache.getUsers().toObservable(),
            githubUserDataSource.getUsers().flatMap (cache::retain).toObservable()
        )



}