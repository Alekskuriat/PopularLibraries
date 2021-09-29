package com.example.popularlibraries.gitHubUsersList.users


import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import com.example.popularlibraries.gitHubUsersList.user.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.observers.ConsumerSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.SingleSubject
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
                .observeOn(Schedulers.io())
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
