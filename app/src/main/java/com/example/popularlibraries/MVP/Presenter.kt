package com.example.popularlibraries.MVP

class Presenter (
    private val view : MainView,
    private val model : Model
) : PresenterInterface {


    override fun oneCounterClick() {
        view.showCounterOne(model.next(0).toString())
    }

    override fun twoCounterClick() {
        view.showCounterTwo(model.next(1).toString())
    }

    override fun threeCounterClick() {
        view.showCounterThree(model.next(2).toString())
    }


}