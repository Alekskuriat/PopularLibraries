package com.example.popularlibraries.gitHubUsersList.model

class GithubUsersRepo {

    /**
     * Список пользователь
     * getUsers() возвращает список пользователей
     * getUserByID(id) возвращает пользователя соответствующего ID
     */

    private val users = listOf(
        GithubUser("login_1"),
        GithubUser("login_2"),
        GithubUser("login_3"),
        GithubUser("login_4"),
        GithubUser("login_5")
    )

    fun getUsers(): List<GithubUser> {
        return users
    }

    fun getUserById(id: String): GithubUser? = getUsers().firstOrNull {
        it.login == id
    }

}