package com.example.popularlibraries.MVP

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView {
    fun showCounterOne(text: String)
    fun showCounterTwo(text: String)
    fun showCounterThree(text: String)
}