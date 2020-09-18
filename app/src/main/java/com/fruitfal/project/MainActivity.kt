package com.fruitfal.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fruitfal.project.adapter.AllCommitAdapter
import com.fruitfal.project.listener.CommitClickListener
import com.fruitfal.project.model.AllCommitsModel
import com.fruitfal.project.viewmodel.AllCommitViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  CommitClickListener{

    var recyclerView: RecyclerView? = null
    var allCommitAdapter: AllCommitAdapter? = null
    var allCommitList: ArrayList<AllCommitsModel>? = ArrayList()

    var allCommitViewModel: AllCommitViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvMain)

        setRecyclerView()

        allCommitViewModel = ViewModelProvider(this).get(AllCommitViewModel::class.java)

        allCommitViewModel!!.loadData()

        allCommitViewModel!!.allCommitLiveData.observe(this, Observer { t ->
            allCommitList!!.addAll(t)
            allCommitAdapter!!.notifyDataSetChanged()
        })

    }

    fun setRecyclerView(){
        allCommitAdapter = AllCommitAdapter(this, allCommitList!!,this)
        recyclerView.apply {
            recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView?.adapter = allCommitAdapter
        }
    }

    override fun onCommitItemClickListener(item: AllCommitsModel.Commit) {

    }

    override fun onDestroy() {
        allCommitViewModel?.reset()
        super.onDestroy()
    }

}