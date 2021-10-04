package com.example.popularlibraries.domain.user.data

import com.example.popularlibraries.domain.api.GithubApi
import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubUserDataSourceImpl(
    private val githubApi: GithubApi
) : GithubUserDataSource {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApi.getListUsers()
    }
}