package com.example.popularlibraries.packageMvp

import moxy.MvpPresenter

class Presenter (
    private val model : Model
) : MvpPresenter<MainView>() {


    fun oneCounterClick() {
        viewState.showCounterOne(model.next(0).toString())
    }

    fun twoCounterClick() {
        viewState.showCounterTwo(model.next(1).toString())
    }

    fun threeCounterClick() {
        viewState.showCounterThree(model.next(2).toString())
    }


}