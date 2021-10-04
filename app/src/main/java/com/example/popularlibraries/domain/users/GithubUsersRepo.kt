package com.example.popularlibraries.domain.users

import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepo {

    fun getUsers(): Single<List<GithubUserModel>>

}