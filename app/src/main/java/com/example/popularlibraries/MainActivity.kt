package com.example.popularlibraries

import android.os.Bundle
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.packageMvp.MainView
import com.example.popularlibraries.packageMvp.Model
import com.example.popularlibraries.packageMvp.Presenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private var binding: ActivityMainBinding? = null

    private val presenter by moxyPresenter { Presenter(Model()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            btnCounter1.setOnClickListener {
                presenter.oneCounterClick()
            }
            btnCounter2.setOnClickListener {
                presenter.twoCounterClick()
            }
            btnCounter3.setOnClickListener {
                presenter.threeCounterClick()
            }
        }

    }


    override fun showCounterOne(text: String) {
        binding?.btnCounter1?.text = text
    }

    override fun showCounterTwo(text: String) {
        binding?.btnCounter2?.text = text
    }

    override fun showCounterThree(text: String) {
        binding?.btnCounter3?.text = text
    }


}


