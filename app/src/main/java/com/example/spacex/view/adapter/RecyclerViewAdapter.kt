package com.example.spacex.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import com.example.spacex.databinding.LaunchItemBinding
import com.example.spacex.view.utils.LaunchResponse
import kotlinx.android.synthetic.main.launch_item.view.*

// TODO:Make this more efficient with DataBinding !!!
class RecyclerViewAdapter(
        private val itemClicked: (item: LaunchResponse) -> Unit = {},
        var launchList: List<LaunchResponse>) : DataBoundListAdapter<LaunchResponse>(
        diffCallback = object : DiffUtil.ItemCallback<LaunchResponse>() {
            override fun areItemsTheSame(oldItem: LaunchResponse, newItem: LaunchResponse): Boolean =
                    oldItem == newItem

            override fun areContentsTheSame(oldItem: LaunchResponse, newItem: LaunchResponse): Boolean =
                    oldItem.flight_number == newItem.flight_number

        }
) {

/*    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_item, parent, false)


        return ItemViewHolder(itemView)
    }*/

/*    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvTest.text = position.toString()
        holder.tvMissionName.text = launchList[position].mission_name

        holder.tvMissionName.setOnClickListener{
            log("Clicked - ${launchList[position].mission_name}")
            Navigation.createNavigateOnClickListener(R.id.action_fragmentMain_to_fragmentInfo, null)

        }
        log("--- Adapter ---")
        log("MissionName: ${launchList[position].missionName}")
        log("MissionName: ${launchList[position].rocket?.rocketName}")
        log("MissionName: ${launchList[position]}")
        holder.tvMissionName.text = position.toString()
        holder.tvRocketName.text = launchList[position].rocket?.rocketName?.toString()
        holder.tvLaunchYear.text = launchList[position].launchYear*//*
    }*/

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
            parent.bind(R.layout.launch_item)

    override fun bind(binding: ViewDataBinding, item: LaunchResponse) {
        when (binding) {
            is LaunchItemBinding -> binding.launch = item
        }
        with(binding.root) {
            tag = item
            setOnClickListener { itemClicked.invoke(item) }
        }
    }

    fun log(string: String){
        println("debugger: $string")
    }
}