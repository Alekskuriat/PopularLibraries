package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersRepoImpl : GithubUsersRepo {

    /**
     * Список пользователь
     * getUsers() возвращает список пользователей
     * getUserByID(id) возвращает пользователя соответствующего ID
     */

    private val users = listOf(
        GithubUserModel(1, "login_1"),
        GithubUserModel(2, "login_2"),
        GithubUserModel(3, "login_3"),
        GithubUserModel(4, "login_4"),
        GithubUserModel(5, "login_5")
    )

    override fun getUsers(): Single<List<GithubUserModel>> =
        Single
            .just(users)
            .map { users ->
                users.map { user ->
                    user.copy(login = user.login.uppercase())
                }
            }
            .subscribeOn(Schedulers.io())


    override fun getUserById(id: Int): Maybe<GithubUserModel> =
        users.firstOrNull { user ->
            user.id == id
        }
            ?.let { user -> Maybe.just(user).subscribeOn(Schedulers.io()) }
            ?: Maybe.empty()


}