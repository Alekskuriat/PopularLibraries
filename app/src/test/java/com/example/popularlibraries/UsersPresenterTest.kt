package com.example.popularlibraries

import com.example.popularlibraries.domain.schedulers.Schedulers
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.presenter.users.UsersPresenter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UsersPresenterTest {

    private lateinit var presenter: UsersPresenter

    @Mock
    private lateinit var repo: GithubUsersRepo

    private lateinit var router: Router

    @Mock
    private lateinit var schedulers: Schedulers


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val cicerone = Cicerone.create()
        router = cicerone.router
        presenter = UsersPresenter(usersRepo = repo, router, schedulers)
    }

    @Test
    fun getUsersList_test() {
        presenter.getUsersList()
        verify(repo, atLeastOnce()).getUsers()
    }

}