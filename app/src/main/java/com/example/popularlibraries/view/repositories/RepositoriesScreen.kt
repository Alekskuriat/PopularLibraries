package com.example.popularlibraries.view.repositories


import com.github.terrakok.cicerone.androidx.FragmentScreen

class RepositoriesScreen {

    fun repositories(url: String) = FragmentScreen { RepositoriesFragment.newInstance(url) }


}