package com.example.popularlibraries.presenter.users


import com.example.popularlibraries.view.repositories.RepositoriesScreen
import com.example.popularlibraries.domain.user.GithubUserModel
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.view.users.UsersView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UsersView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        disposable.add(
            usersRepo
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
        )
    }

    fun openUserInfo(user: GithubUserModel) = router.navigateTo(RepositoriesScreen().repositories(user.repos_url))

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
