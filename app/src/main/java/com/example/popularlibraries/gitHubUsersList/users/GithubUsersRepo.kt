package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepo {

    fun getUsers(): Single<List<GithubUserModel>>

}