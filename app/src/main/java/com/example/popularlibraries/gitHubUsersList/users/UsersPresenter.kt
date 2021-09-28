package com.example.popularlibraries.gitHubUsersList.users


import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import com.example.popularlibraries.gitHubUsersList.user.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router
    ) : MvpPresenter<UsersView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            usersRepo
                .getUsers()
                .subscribe(
                viewState::showUsers,
                viewState::showError
            )
        )

    }

    fun openUserInfo(user: GithubUserModel) = router.navigateTo(UserScreen().user(user.id))

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
