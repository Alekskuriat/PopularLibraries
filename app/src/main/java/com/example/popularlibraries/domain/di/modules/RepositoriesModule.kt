package com.example.popularlibraries.domain.di.modules

import com.example.popularlibraries.domain.repositories.GithubRepoRepositories
import com.example.popularlibraries.domain.repositories.GithubRepoRepositoriesImpl
import com.example.popularlibraries.domain.repositories.cache.CacheUserRepoDataSource
import com.example.popularlibraries.domain.repositories.cache.CacheUserRepoDataSourceImpl
import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSource
import com.example.popularlibraries.domain.repositories.data.GithubUserRepoDataSourceImpl
import com.example.popularlibraries.view.repositories.RepositoriesFragment
import com.example.popularlibraries.view.repository.RepositoryFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface RepositoriesModule {

    @ContributesAndroidInjector
    fun bindRepositoriesFragment(): RepositoriesFragment

    @ContributesAndroidInjector
    fun bindRepositoryFragment(): RepositoryFragment

    @Binds
    fun bindGithubRepoRepositories(githubRepoRepositoriesImpl: GithubRepoRepositoriesImpl): GithubRepoRepositories

    @Binds
    fun bindGithubUserRepoDataSource(githubUserRepoDataSourceImpl: GithubUserRepoDataSourceImpl): GithubUserRepoDataSource

    @Binds
    fun bindCacheUserRepoDataSource(cacheUserRepoDataSourceImpl: CacheUserRepoDataSourceImpl): CacheUserRepoDataSource


}