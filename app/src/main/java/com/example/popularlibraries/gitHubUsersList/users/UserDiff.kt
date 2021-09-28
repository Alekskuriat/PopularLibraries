package com.example.popularlibraries.gitHubUsersList.users

import androidx.recyclerview.widget.DiffUtil
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel

class UserDiff(
    private val oldList: List<GithubUserModel>,
    private val newList: List<GithubUserModel>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].login == newList[newItemPosition].login
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
