package com.example.popularlibraries.gitHubUsersList.user


import com.example.popularlibraries.gitHubUsersList.users.GithubUsersRepoImpl
import com.example.popularlibraries.gitHubUsersList.App
import com.example.popularlibraries.gitHubUsersList.users.GithubUsersRepo
import com.example.popularlibraries.gitHubUsersList.users.UsersScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userId: Int?,
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UserView>() {

    private val disposable = CompositeDisposable()


    override fun onFirstViewAttach() {

        if (userId == null) return

        disposable.add(
            usersRepo.getUserById(userId)
                .observeOn(Schedulers.io())
                .map {
                    it.copy(login = it.login.replace("_", " ").uppercase())
                }
                .subscribe(
                    viewState::showNameUser,
                    viewState::showError,
                )
        )

    }

    fun backPressed(): Boolean {
        router.newRootChain(UsersScreen().users())
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
