package com.example.spacex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import com.example.spacex.view.utils.LaunchResponse
import kotlinx.android.synthetic.main.launch_item.view.*

class RecyclerViewAdapter(var launchList: List<LaunchResponse>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_item, parent, false)

        return ItemViewHolder(itemView)
    }


    // TODO:Make this more efficient with DataBinding
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvMissionName.text = position.toString()
        /*log("--- Adapter ---")
        log("MissionName: ${launchList[position].missionName}")
        log("MissionName: ${launchList[position].rocket?.rocketName}")
        log("MissionName: ${launchList[position]}")
        holder.tvMissionName.text = position.toString()
        holder.tvRocketName.text = launchList[position].rocket?.rocketName?.toString()
        holder.tvLaunchYear.text = launchList[position].launchYear*/
    }

    // Returns size of the list
    override fun getItemCount(): Int = launchList.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // Assigning references to single 'row' items in our item xml file
        // Notice that we don't have to use findViewById here as with Java
        val tvMissionName: TextView = itemView.tv_mission_name
        val tvRocketName: TextView = itemView.tv_rocket_name
        val tvLaunchYear: TextView = itemView.tv_launch_year
    }

    fun log(string: String){
        println("debugger: $string")
    }
}