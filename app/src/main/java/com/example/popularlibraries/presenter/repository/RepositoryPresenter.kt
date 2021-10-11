package com.example.popularlibraries.presenter.repository

import com.example.popularlibraries.view.repository.RepositoryView
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class RepositoryPresenter
    @AssistedInject constructor(
        @Assisted private val forks: Int?,
        private val router: Router
) : MvpPresenter<RepositoryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        forks?.let {
            viewState.showRepositoryInfo(it)
        } ?: viewState.showError(Exception("Forks null"))


    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}