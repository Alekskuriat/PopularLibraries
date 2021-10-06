package com.example.popularlibraries.domain.users

import com.example.popularlibraries.domain.user.GithubUserModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepo {

    fun getUsers(): Observable<List<GithubUserModel>>

    //fun getUserByLogin(userId : Int) : Maybe<GithubUserModel>

}