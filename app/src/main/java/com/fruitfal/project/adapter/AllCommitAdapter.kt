package com.fruitfal.project.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fruitfal.project.R
import com.fruitfal.project.listener.CommitClickListener
import com.fruitfal.project.model.AllCommitsModel
import com.fruitfal.project.viewholder.AllCommitViewHolder

class AllCommitAdapter(val context: Context?, val allCommitList: List<AllCommitsModel>, val commitClickListener: CommitClickListener) : RecyclerView.Adapter<AllCommitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCommitViewHolder {
        return AllCommitViewHolder(LayoutInflater.from(context).inflate(R.layout.card_all_commit_layout,parent,false))
    }

    override fun onBindViewHolder(holder: AllCommitViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: "+allCommitList.size)

        var allCommitsModel: AllCommitsModel = allCommitList[position]

        holder.tvAuthorName.text = allCommitsModel.commit!!.author!!.name
        holder.tvCommitDate.text = allCommitsModel.commit!!.author!!.date
        holder.tvCommitMsg.text = allCommitsModel.commit!!.message

    }

    override fun getItemCount(): Int {
        return allCommitList.size
    }
}