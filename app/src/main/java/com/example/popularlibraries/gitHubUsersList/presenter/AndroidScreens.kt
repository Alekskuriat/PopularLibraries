package com.example.popularlibraries.gitHubUsersList.presenter

import com.example.popularlibraries.gitHubUsersList.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}