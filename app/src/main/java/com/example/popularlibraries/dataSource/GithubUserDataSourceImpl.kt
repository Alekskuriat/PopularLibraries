package com.example.popularlibraries.dataSource

import com.example.popularlibraries.api.GithubApi
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubUserDataSourceImpl(
    private val githubApi: GithubApi
) : GithubUserDataSource {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApi.getListUsers()
    }
}