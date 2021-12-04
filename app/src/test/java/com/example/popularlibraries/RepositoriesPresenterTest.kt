package com.example.popularlibraries

import com.example.popularlibraries.domain.repositories.GithubRepoRepositories
import com.example.popularlibraries.domain.schedulers.Schedulers
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.presenter.repositories.RepositoriesPresenter
import com.example.popularlibraries.presenter.users.UsersPresenter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RepositoriesPresenterTest {

    private lateinit var presenter: RepositoriesPresenter

    @Mock
    private lateinit var repo: GithubRepoRepositories

    private lateinit var router: Router

    private lateinit var url: String

    @Mock
    private lateinit var schedulers: Schedulers


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val cicerone = Cicerone.create()
        router = cicerone.router
        url = "Named"
        presenter = RepositoriesPresenter(
            gitHubReposRepository = repo,
            url,
            router,
            schedulers
        )
    }

    @Test
    fun getRepositoriesList_test() {
        presenter.getRepositories(url)
        verify(repo, atLeastOnce()).getRepositories(url)
    }

    @Test
    fun getRepositoriesList_nullUrl_test() {
        presenter.getRepositories("")
        assertEquals(presenter.getRepositories(""), "Error")
    }

    @Test
    fun getRepositoriesList_url_test() {
        url = "abc"
        presenter.getRepositories(url)
        assertEquals(presenter.getRepositories(url), "Ok")

    }

}
