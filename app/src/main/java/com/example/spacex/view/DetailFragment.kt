package com.example.spacex.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.spacex.model.LaunchItem
import com.example.spacex.util.LAUNCH_INFO
import com.example.spacex.view.components.LaunchDetailsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.getParcelable<LaunchItem>(LAUNCH_INFO).let { details ->
            return ComposeView(requireContext()).apply {
                setContent {
                    println("dbg ${details?.missionName}")
                    LaunchDetailsScreen(details) { urlClicked ->
                        onLinkClicked(urlClicked)
                    }
                }
            }
        }
    }

    private fun onLinkClicked(url: String?) {
        if (url.isNullOrEmpty()) {
            Toast.makeText(context, "Can`t open this link", Toast.LENGTH_SHORT).show()
        }
        else {
            Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
                startActivity(this)
            }
        }
    }
}