package com.example.popularlibraries.presenter.users

import com.example.popularlibraries.view.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen {
    fun users() = FragmentScreen { UsersFragment.newInstance() }
}