package com.example.popularlibraries.packageMvp

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun showCounterOne(text: String)
    fun showCounterTwo(text: String)
    fun showCounterThree(text: String)
}