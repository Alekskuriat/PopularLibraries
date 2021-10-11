package com.example.popularlibraries

import android.os.Bundle
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.ActivityMainHw2Binding
import com.example.popularlibraries.domain.App
import com.example.popularlibraries.domain.abs.AbsActivity
import com.example.popularlibraries.presenter.users.UsersScreen
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main_hw_2) {

    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(UsersScreen().users())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()

    }

}