package com.example.popularlibraries

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

interface ItemView {
    var pos : Int
}

interface UserItemView: ItemView {
    fun setLogin(text: String)
}

interface IListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>


interface MainView : MvpView {
}

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : MvpView {
    fun init()
    fun updateList()
}

@SingleState
interface UserView : MvpView {
    fun showNameUser(nameUser : String)
}

interface BackButtonListener {
    fun backPressed(): Boolean
}