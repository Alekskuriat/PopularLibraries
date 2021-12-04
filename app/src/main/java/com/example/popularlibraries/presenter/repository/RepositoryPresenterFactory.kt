package com.example.popularlibraries.presenter.repository

import dagger.assisted.AssistedFactory

@AssistedFactory
interface RepositoryPresenterFactory {

    fun create(forks: Int): RepositoryPresenter
}