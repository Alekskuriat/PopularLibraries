package com.example.popularlibraries.gitHubUsersList.user


import com.example.popularlibraries.gitHubUsersList.users.GithubUsersRepo
import com.example.popularlibraries.gitHubUsersList.App
import com.example.popularlibraries.gitHubUsersList.users.UsersScreen
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UserPresenter(
    private val userId: Int?,
    private val usersRepo: GithubUsersRepo
) : MvpPresenter<UserView>() {

    private val disposable = CompositeDisposable()


    override fun onFirstViewAttach() {

        if (userId == null) return

        disposable.add(
            usersRepo.getUserById(userId)
                .subscribe(
                    viewState::showNameUser,
                    viewState::showError,
                )
        )

    }

    fun backPressed(): Boolean {
        App.instance.router.newRootChain(UsersScreen().users())
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
