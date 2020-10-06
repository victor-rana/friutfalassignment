package com.fruitfal.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fruitfal.project.fragment.CommitFragment
import com.fruitfal.project.fragment.DetailsFragment
import com.fruitfal.project.model.AllCommitsModel
import com.fruitfal.project.viewmodel.AllCommitViewModel

class MainActivity : AppCompatActivity(){


    var allCommitViewModel: AllCommitViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allCommitViewModel = ViewModelProvider(this).get(AllCommitViewModel::class.java)

        loadFragment()

    }

    fun loadFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmentMain, CommitFragment())
        ft.commit()
    }

    fun onLoadDetailsFragment(item: AllCommitsModel.Commit){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmentMain, DetailsFragment(item))
        ft.addToBackStack(DetailsFragment().tag)
        ft.commit()
    }

    override fun onDestroy() {
        allCommitViewModel?.reset()
        super.onDestroy()
    }

    override fun onBackPressed() {

        val count = supportFragmentManager.backStackEntryCount

        if (count == 0) {
            super.onBackPressed()
            //additional code
        } else {
            supportFragmentManager.popBackStack()
        }


    }

}