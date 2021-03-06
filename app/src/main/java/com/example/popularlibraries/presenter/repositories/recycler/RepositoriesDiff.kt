package com.example.popularlibraries.presenter.repositories.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.popularlibraries.domain.repositories.GithubRepositories

class RepositoriesDiff (
    private val oldList: List<GithubRepositories>,
    private val newList: List<GithubRepositories>
    ) : DiffUtil.Callback() {


        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].name == newList[newItemPosition].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }

