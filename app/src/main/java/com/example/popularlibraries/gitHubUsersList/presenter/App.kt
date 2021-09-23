package com.example.popularlibraries.gitHubUsersList.presenter

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    //Если сделать так, как указано в методичке
    // приложение падает из-за непроинициализированного instance

    companion object Navigation {
         var instance: App = App()
    }

/*
    companion object {
        lateinit var instance: App
    }
*/


    //Временно до даггера положим это тут
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    /*override fun onCreate() {
        super.onCreate()
        instance = this
    }*/


}