package com.example.popularlibraries.view.repository

import com.example.popularlibraries.view.repositories.RepositoriesFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class RepositoryScreen {

    fun repositoryInfoForks(forks: Int) = FragmentScreen { RepositoryFragment.newInstance(forks) }
}