package com.example.popularlibraries

import android.os.Bundle
import com.example.popularlibraries.databinding.ActivityMainHw2Binding
import com.example.popularlibraries.gitHubUsersList.App
import com.example.popularlibraries.gitHubUsersList.users.UsersScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(R.layout.activity_main_hw_2) {

    private val navigator = AppNavigator(this, R.id.container)

    private var viewBinding: ActivityMainHw2Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainHw2Binding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        savedInstanceState ?: App.instance.router.newRootScreen(UsersScreen().users())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()

    }

}