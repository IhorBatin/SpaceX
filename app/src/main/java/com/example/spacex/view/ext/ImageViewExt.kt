package com.example.spacex.view.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.spacex.R
import com.squareup.picasso.Picasso

@BindingAdapter("loadImg")
fun ImageView.loadImg(imageUrl: String?){
    // Load Image here TODO: Switch to Coil Library
    return Picasso.get().load(imageUrl).into(this)
}