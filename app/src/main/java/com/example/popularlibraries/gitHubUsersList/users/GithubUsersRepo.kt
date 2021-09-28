package com.example.popularlibraries.gitHubUsersList.users

import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {

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

    fun getUsers(): Observable<List<GithubUserModel>> =
        Observable.just(users)


    fun getUserById(id : Int) : Observable<GithubUserModel> {
        return getUsers()
            .flatMap { Observable.fromIterable(it) }
            .filter { it.id == id }
    }

}