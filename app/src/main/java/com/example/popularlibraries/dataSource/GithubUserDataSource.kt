package com.example.popularlibraries.dataSource

import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDataSource {
    fun getUsers(): Single<List<GithubUserModel>>
}