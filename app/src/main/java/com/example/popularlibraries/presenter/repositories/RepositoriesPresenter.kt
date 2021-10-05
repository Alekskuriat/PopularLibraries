package com.example.popularlibraries.presenter.repositories

import com.example.popularlibraries.domain.repositories.GithubRepoRepositories
import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.view.repositories.RepositoriesView
import com.example.popularlibraries.view.repository.RepositoryScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
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

        viewState.showLoading()

        url?.let {
            disposable.add(
                gitHubReposRepository
                    .getRepositories(it!!)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        viewState::showRepositories,
                        viewState::showError
                    )
            )
        } ?: viewState.showError(Exception("Url null"))


    }

    fun repositoryInfo(githubRepositories: GithubRepositories) =
        router.navigateTo(RepositoryScreen().repositoryInfoForks(githubRepositories.forks))


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}