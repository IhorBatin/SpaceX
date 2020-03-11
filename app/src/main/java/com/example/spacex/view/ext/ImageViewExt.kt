package com.example.spacex.view.ext

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadImg")
fun ImageView.loadImg(imageUrl: String?){
    //TODO: Switch to Coil Library
    return Picasso.get().load(imageUrl).into(this)
}

@BindingAdapter("showDate")
fun showDate(view: TextView, date: String){
    view.text  = "Some Random Date ...$date"
}
//TODO: FIX THE DATE NOT SHOWING ISSUE !!!!!!!
