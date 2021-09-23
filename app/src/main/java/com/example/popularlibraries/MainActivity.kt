package com.example.popularlibraries

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.databinding.ActivityMainHw2Binding
import com.example.popularlibraries.gitHubUsersList.GithubUsersRepo
import com.example.popularlibraries.gitHubUsersList.MainPresenter
import com.example.popularlibraries.gitHubUsersList.UsersRVAdapter
import com.example.popularlibraries.packageMvp.MainView
import com.example.popularlibraries.packageMvp.Model
import com.example.popularlibraries.packageMvp.Presenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main_hw_2), com.example.popularlibraries.MainView {

    private var binding: ActivityMainHw2Binding? = null

    private val presenter by moxyPresenter { MainPresenter(GithubUsersRepo()) }
    private var adapter: UsersRVAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainHw2Binding.inflate(layoutInflater)
        setContentView(binding?.root)

    }

    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(this)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding?.rvUsers?.adapter = adapter

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

}


