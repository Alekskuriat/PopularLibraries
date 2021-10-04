package com.example.popularlibraries.gitHubUsersList.repositories

import com.example.popularlibraries.gitHubUsersList.repo.GithubRepoRepositories
import com.example.popularlibraries.gitHubUsersList.repo.GithubRepositories
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter(
    private val gitHubReposRepository: GithubRepoRepositories,
    private val url: String?,
    private val router: Router
) : MvpPresenter<RepositoriesView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        if (url == null) viewState.showError(Exception("Url null"))

        url.let {
            disposable.add(
                gitHubReposRepository
                    .getRepositories(it!!)
                    .observeOn(Schedulers.io())
                    .subscribe(
                        viewState::showRepositories,
                        viewState::showError
                    )
            )
        }


    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}