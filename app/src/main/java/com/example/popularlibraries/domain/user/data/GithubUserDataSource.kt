package com.example.popularlibraries.domain.user.data

import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDataSource {
    fun getUsers(): Single<List<GithubUserModel>>
}