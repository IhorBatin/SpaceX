package com.example.spacex.view.ext

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadImg")
fun ImageView.loadImg(imageUrl: String?){
    //TODO: Switch to Coil Library
    return Picasso.get().load(imageUrl).into(this)
}
