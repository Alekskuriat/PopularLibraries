package com.example.popularlibraries.domain.di

import android.content.Context
import com.example.popularlibraries.domain.App
import com.example.popularlibraries.domain.di.modules.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import com.example.popularlibraries.domain.schedulers.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import javax.inject.Singleton

@Singleton
@Component
    (modules = [
    AndroidInjectionModule::class,
    UserModule::class,
    StorageModule::class,
    GithubApiModule::class,
    RepositoriesModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent
    }


}