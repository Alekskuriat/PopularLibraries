package com.example.popularlibraries.presenter.repositories

import dagger.assisted.AssistedFactory

@AssistedFactory
interface RepositoriesPresenterFactory {

    fun create(url: String): RepositoriesPresenter

}