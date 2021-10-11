package com.example.popularlibraries.domain.user.data

import com.example.popularlibraries.domain.api.GithubApi
import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUserDataSourceImpl
    @Inject constructor(
    private val githubApi: GithubApi
) : GithubUserDataSource {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApi.getListUsers()
    }


}