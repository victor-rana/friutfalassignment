package com.fruitfal.project.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_all_commit_layout.view.*

class AllCommitViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvAuthorName = v.tvAuthorName
    val tvCommitDate = v.tvCommitDate
    val tvCommitMsg = v.tvCommitMsg
    val llCard = v.llCard
}