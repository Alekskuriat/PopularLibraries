package com.example.popularlibraries.gitHubUsersList.repositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.R
import com.example.popularlibraries.gitHubUsersList.repo.GithubRepositories
import com.example.popularlibraries.gitHubUsersList.user.GithubUserModel
import com.example.popularlibraries.gitHubUsersList.user.UserClickListener
import com.example.popularlibraries.gitHubUsersList.users.UserDiff
import com.example.popularlibraries.gitHubUsersList.users.UserItemView

class RepositoriesAdapter(
    private val delegate: RepoClickListener
) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    interface RepoClickListener {
        fun onClickRepo(repo: GithubRepositories)
    }

    private val list: MutableList<GithubRepositories> = mutableListOf()

    fun submit(repositories: List<GithubRepositories>) {
        val callback = RepositoriesDiff(
            oldList = list,
            newList = repositories
        )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(repositories)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_repositories,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickRepo(it.tag as GithubRepositories)
        }
        return ViewHolder(rootView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private var repoName: TextView = itemView.findViewById(R.id.repo_name)

        fun bind(repo: GithubRepositories) {
            repoName.text = repo.name
        }
    }
}
