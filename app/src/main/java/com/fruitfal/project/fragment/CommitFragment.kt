package com.fruitfal.project.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fruitfal.project.MainActivity
import com.fruitfal.project.R
import com.fruitfal.project.adapter.AllCommitAdapter
import com.fruitfal.project.listener.CommitClickListener
import com.fruitfal.project.model.AllCommitsModel
import com.fruitfal.project.viewmodel.AllCommitViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommitFragment : Fragment(), CommitClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val TAG = "CommitFragment"

    var recyclerView: RecyclerView? = null
    var allCommitAdapter: AllCommitAdapter? = null
    var allCommitList: ArrayList<AllCommitsModel>? = ArrayList()

    var allCommitViewModel: AllCommitViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvMain)

        setRecyclerView()

        allCommitViewModel = ViewModelProvider(activity!!).get(AllCommitViewModel::class.java)

        allCommitViewModel?.loadData()

        allCommitViewModel!!.allCommitLiveData.observe(this, Observer { t ->
            allCommitList!!.addAll(t)
            allCommitAdapter!!.notifyDataSetChanged()
        })


    }

    fun setRecyclerView(){
        allCommitAdapter = AllCommitAdapter(context, allCommitList!!, this)
        recyclerView.apply {
            recyclerView?.layoutManager = LinearLayoutManager(context)
            recyclerView?.adapter = allCommitAdapter
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommitFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        allCommitViewModel?.reset()
        super.onDestroy()
    }

    override fun onCommitItemClickListener(item: AllCommitsModel.Commit) {
        (activity as MainActivity?)!!.onLoadDetailsFragment(item)
    }
}