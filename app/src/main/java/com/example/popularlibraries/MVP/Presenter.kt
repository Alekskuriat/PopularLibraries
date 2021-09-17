package com.example.popularlibraries.MVP

class Presenter (
    private val view : MainView
) : PresenterInterface {

    private val model = Model()

    override fun oneCounterClick() {
        view.setOneButtonText(model.next(0).toString())
    }

    override fun twoCounterClick() {
        view.setTwoButtonText(model.next(1).toString())
    }

    override fun threeCounterClick() {
        view.setThreeButtonText(model.next(2).toString())
    }


}