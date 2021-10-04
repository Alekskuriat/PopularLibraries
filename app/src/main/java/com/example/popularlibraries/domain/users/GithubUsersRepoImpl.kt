package com.example.popularlibraries.domain.users

import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.user.data.GithubUserDataSource
import io.reactivex.rxjava3.core.Single

class GithubUsersRepoImpl(
    private val githubUserDataSource: GithubUserDataSource
) : GithubUsersRepo {



    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubUserDataSource.getUsers()
    }


}