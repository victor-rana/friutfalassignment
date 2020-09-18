package com.fruitfal.project.listener

import com.fruitfal.project.model.AllCommitsModel


interface CommitClickListener {
    fun onCommitItemClickListener(item: AllCommitsModel.Commit)
}