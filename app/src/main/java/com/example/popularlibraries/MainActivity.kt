package com.example.popularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.popularlibraries.MVP.MainView
import com.example.popularlibraries.MVP.Presenter
import com.example.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null

    val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.btnCounter1?.setOnClickListener {
            presenter.oneCounterClick()
        }
        vb?.btnCounter2?.setOnClickListener {
            presenter.twoCounterClick()
        }
        vb?.btnCounter3?.setOnClickListener {
            presenter.threeCounterClick()
        }
    }


    override fun setOneButtonText(text: String) {
        vb?.btnCounter1?.text = text
    }

    override fun setTwoButtonText(text: String) {
        vb?.btnCounter2?.text = text
    }

    override fun setThreeButtonText(text: String) {
        vb?.btnCounter3?.text = text
    }


}


