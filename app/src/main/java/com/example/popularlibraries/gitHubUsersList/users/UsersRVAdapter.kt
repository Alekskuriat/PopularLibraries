package com.example.popularlibraries.gitHubUsersList.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import androidx.recyclerview.widget.DiffUtil
import com.example.popularlibraries.R
import com.example.popularlibraries.gitHubUsersList.user.UserClickListener


class UsersRVAdapter(
    private val delegate: UserClickListener
) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    private val list: MutableList<GithubUserModel> = mutableListOf()

    fun submit(users: List<GithubUserModel>) {
        val callback = UserDiff(
            list,
            users
        )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(users)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickUser(it.tag as GithubUserModel)
        }
        return ViewHolder(rootView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setLogin(list[position])
        holder.itemView.tag = list[position]
    }


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item),
        UserItemView {

        private var userLogin: TextView = itemView.findViewById(R.id.tv_login)

        override var pos = -1

        override fun setLogin(user: GithubUserModel) {
            userLogin.text = user.login
        }
    }
}