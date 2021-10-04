package com.example.popularlibraries.presenter.repository

import com.example.popularlibraries.view.repository.RepositoryView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepositoryPresenter(
    private val forks: Int?,
    private val router: Router
) : MvpPresenter<RepositoryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        if (forks == null) viewState.showError(Exception("Forks null"))

        forks?.let {
            viewState.showRepositoryInfo(it)
        }


    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}