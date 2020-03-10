package com.example.spacex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex.R
import com.example.spacex.view.adapter.RecyclerViewAdapter
import com.example.spacex.view.utils.LaunchResponse
import com.example.spacex.view.viewmodel.SpacexViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : Fragment() {
    private val model: SpacexViewModel by lazy { ViewModelProvider(this).get(SpacexViewModel::class.java)}
    private var launchAdapter: RecyclerViewAdapter? = null

    private val itemClicked: (LaunchResponse) -> Unit = {
        Toast.makeText(requireContext(), "Loading... ${it.mission_name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("onViewCreated()-Start")

        rv_container.apply {
            launchAdapter = RecyclerViewAdapter(itemClicked)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = launchAdapter
            itemAnimator = DefaultItemAnimator()
        }
        setupObservers()
        log("onViewCreated()-End")
    }

    private fun setupObservers(){
        log("setupObservers()-Start")
        model.spacexLiveData.observe(viewLifecycleOwner, Observer {
            log("launchList size -> ${it.size}")
            val adapterItemCount = launchAdapter?.itemCount?.minus(1) ?: -1
            val insertIndex = if (adapterItemCount < 0) 0 else adapterItemCount
            launchAdapter?.submitList(it)
            launchAdapter?.notifyItemRangeInserted(insertIndex, it.size)
        })
        log("setupObservers()-End")
    }

    fun log(string: String){
        println("debugger FragmentMain: $string")
    }

    fun printAll(list: List<LaunchResponse>){
        log("printing ${list.size} elements ...")
        for (element in list) {
            log("ID: ${element.mission_name}")
        }
    }
}