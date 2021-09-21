package com.example.popularlibraries

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