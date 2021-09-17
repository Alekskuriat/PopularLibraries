package com.example.popularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibraries.MVP.MainView
import com.example.popularlibraries.MVP.Presenter
import com.example.popularlibraries.MVP.PresenterInterface
import com.example.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private var B: ActivityMainBinding? = null

    private val presenter: PresenterInterface = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        B = ActivityMainBinding.inflate(layoutInflater)
        setContentView(B?.root)

        B?.apply {
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


    override fun setOneButtonText(text: String) {
        B?.btnCounter1?.text = text
    }

    override fun setTwoButtonText(text: String) {
        B?.btnCounter2?.text = text
    }

    override fun setThreeButtonText(text: String) {
        B?.btnCounter3?.text = text
    }


}


