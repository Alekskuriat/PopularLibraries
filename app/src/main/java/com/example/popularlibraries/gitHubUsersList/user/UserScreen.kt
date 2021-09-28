package com.example.popularlibraries.gitHubUsersList.user

import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen {

    fun user(userId : Int) = FragmentScreen { UserFragment.newInstance(userId)}

}