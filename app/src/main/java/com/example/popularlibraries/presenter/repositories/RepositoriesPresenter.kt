package com.example.popularlibraries.presenter.repositories

import com.example.popularlibraries.domain.repositories.GithubRepoRepositories
import com.example.popularlibraries.domain.repositories.GithubRepositories
import com.example.popularlibraries.view.repositories.RepositoriesView
import com.example.popularlibraries.view.repository.RepositoryScreen
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter
@AssistedInject constructor(
    private val gitHubReposRepository: GithubRepoRepositories,
    @Assisted private val url: String,
    private val router: Router,
    private val schedulers: com.example.popularlibraries.domain.schedulers.Schedulers
) : MvpPresenter<RepositoriesView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        disposable.add(
            gitHubReposRepository
                .getRepositories(url)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showRepositories,
                    viewState::showError
                )
        )
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