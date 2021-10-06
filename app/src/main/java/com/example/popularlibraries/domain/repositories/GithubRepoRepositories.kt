package com.example.popularlibraries.domain.repositories

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GithubRepoRepositories {
    fun getRepositories(): Observable<List<GithubRepositories>>
}