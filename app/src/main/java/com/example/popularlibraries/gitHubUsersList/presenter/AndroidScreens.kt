package com.example.popularlibraries.gitHubUsersList.presenter

import com.example.popularlibraries.gitHubUsersList.views.UserFragment
import com.example.popularlibraries.gitHubUsersList.views.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(userName : String) = FragmentScreen { UserFragment.newInstance(userName)}
}