package com.example.popularlibraries.gitHubUsersList

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    companion object Navigation {
         var instance: App = App()
    }

    //Временно до даггера положим это тут
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    /*override fun onCreate() {
        super.onCreate()
        instance = this
    }*/

}