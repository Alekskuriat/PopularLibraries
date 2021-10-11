package com.example.popularlibraries.domain.di.modules

import com.example.popularlibraries.MainActivity
import com.example.popularlibraries.domain.user.cache.CacheUserDataSource
import com.example.popularlibraries.domain.user.cache.CacheUserDataSourceImpl
import com.example.popularlibraries.domain.user.data.GithubUserDataSource
import com.example.popularlibraries.domain.user.data.GithubUserDataSourceImpl
import com.example.popularlibraries.domain.users.GithubUsersRepo
import com.example.popularlibraries.domain.users.GithubUsersRepoImpl
import com.example.popularlibraries.view.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface UserModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @Binds
    fun bindCacheUserDataSource(cacheUserDataSourceImpl: CacheUserDataSourceImpl): CacheUserDataSource

    @Binds
    fun bindGithubUserDataSource(githubUserDataSourceImpl: GithubUserDataSourceImpl): GithubUserDataSource

    @Binds
    fun bindGithubUsersRepo(githubUsersRepoImpl: GithubUsersRepoImpl): GithubUsersRepo


}
