package com.example.spacex.view.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.spacex.R
import com.example.spacex.databinding.LaunchItemBinding
import com.example.spacex.view.ext.bind
import com.example.spacex.view.utils.LaunchResponse

class RecyclerViewAdapter(
        private val itemClicked: (item: LaunchResponse) -> Unit = {}) : DataBoundListAdapter<LaunchResponse>(
        diffCallback = object : DiffUtil.ItemCallback<LaunchResponse>() {
            override fun areItemsTheSame(oldItem: LaunchResponse, newItem: LaunchResponse): Boolean =
                    oldItem == newItem

            override fun areContentsTheSame(oldItem: LaunchResponse, newItem: LaunchResponse): Boolean =
                    oldItem.flight_number == newItem.flight_number
        }
) {

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