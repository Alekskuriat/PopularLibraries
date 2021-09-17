package com.example.popularlibraries.MVP

class Presenter(
    val view : MainView
) {
    val model = Model()

    fun oneCounterClick() {
        val nextValue = model.next(0)
        view.setOneButtonText(nextValue.toString())
    }

    fun twoCounterClick() {
        val nextValue = model.next(1)
        view.setTwoButtonText(nextValue.toString())
    }

    fun threeCounterClick() {
        val nextValue = model.next(2)
        view.setThreeButtonText(nextValue.toString())
    }


}