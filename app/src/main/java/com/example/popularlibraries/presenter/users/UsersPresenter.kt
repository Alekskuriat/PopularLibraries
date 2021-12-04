package com.example.popularlibraries.presenter.users


import com.example.popularlibraries.view.repositories.RepositoriesScreen
import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.view.users.UsersView
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter
    @Inject constructor(
    private val usersRepo: GithubUsersRepo,
    private val router: Router,
    private val schedulers: com.example.popularlibraries.domain.schedulers.Schedulers
) : MvpPresenter<UsersView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        disposable.add(
            usersRepo
                .getUsers()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
        )
    }

    fun getUsersList() {
        viewState.showLoading()
        usersRepo.getUsers()
    }

    fun openUserInfo(user: GithubUserModel) =
        router
            .navigateTo(RepositoriesScreen()
                .repositories(user.reposUrl))

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
