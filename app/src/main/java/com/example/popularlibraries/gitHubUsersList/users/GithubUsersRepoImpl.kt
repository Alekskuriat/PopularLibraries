package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.dataSource.GithubUserDataSource
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersRepoImpl(
    private val githubUserDataSource: GithubUserDataSource
) : GithubUsersRepo {



    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubUserDataSource.getUsers()
    }


}