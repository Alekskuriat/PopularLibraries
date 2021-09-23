package com.example.popularlibraries.gitHubUsersList.presenter

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users() : Screen
    fun user() : Screen
}