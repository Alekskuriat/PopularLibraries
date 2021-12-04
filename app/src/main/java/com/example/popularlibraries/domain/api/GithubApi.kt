package com.example.popularlibraries.domain.api

import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface GithubApi {

    @GET("/users")
    fun getListUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepositories(@Url url: String): Single<List<GithubRepositories>>



}