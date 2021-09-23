package com.example.popularlibraries.gitHubUsersList.model

class GithubUsersRepo {

    /**
     * Список пользователь
     * getUsers() возвращает список пользователей
     * getUserByID(id) возвращает пользователя соответствующего ID
     */

    fun getUsers() : List<GithubUser> {
        return listOf(
            GithubUser("login_1"),
            GithubUser("login_2"),
            GithubUser("login_3"),
            GithubUser("login_4"),
            GithubUser("login_5")
        )
    }

    fun getUserById(id : String) : GithubUser? = getUsers().firstOrNull {
        it.login == id
    }

}