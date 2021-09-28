package com.example.popularlibraries.gitHubUsersList.users

import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen {
    fun users() = FragmentScreen { UsersFragment.newInstance() }
}