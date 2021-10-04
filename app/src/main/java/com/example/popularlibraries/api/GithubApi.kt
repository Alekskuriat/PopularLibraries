package com.example.popularlibraries.api

import com.example.popularlibraries.gitHubUsersList.user.GithubRepositories
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface GithubApi {

    @GET("/users")
    fun getListUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepositories(@Url url: String): Single<List<GithubRepositories>>


}