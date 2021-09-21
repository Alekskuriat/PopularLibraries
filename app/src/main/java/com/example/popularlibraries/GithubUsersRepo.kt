package com.example.popularlibraries

class GithubUsersRepo {


    fun getUsers() : List<GithubUser> {
        return listOf(
            GithubUser("login_1"),
            GithubUser("login_2"),
            GithubUser("login_3"),
            GithubUser("login_4"),
            GithubUser("login_5"))
    }

}