package com.example.popularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibraries.MVP.MainView
import com.example.popularlibraries.MVP.Model
import com.example.popularlibraries.MVP.Presenter
import com.example.popularlibraries.MVP.PresenterInterface
import com.example.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private var binding: ActivityMainBinding? = null

    private val presenter: PresenterInterface = Presenter(this, Model())

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


