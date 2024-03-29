package com.example.spacex.util

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

/**
 * Function to asynchronously load images into Compose Image view
 */
@SuppressLint("UnrememberedMutableState")
@Composable
fun loadImage(
    url: String?,
    @DrawableRes defaultImage: Int
): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide
        .with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }
            override fun onLoadCleared(placeholder: Drawable?) { }
        })

    url?.let {
        Glide
            .with(LocalContext.current)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    when (checkBitmapNeedsResizing(resource)) {
                        true -> bitmapState.value = resizeBitmap(resource)
                        false -> bitmapState.value = resource
                    }
                }
                override fun onLoadCleared(placeholder: Drawable?) { }
            })
    }
    
    return bitmapState
}

private fun checkBitmapNeedsResizing(bitmap: Bitmap) =
    (bitmap.height > MAX_REC_BTMP_HEIGHT || bitmap.width > MAX_REC_BTMP_WIDTH)

private fun resizeBitmap(bitmap: Bitmap): Bitmap {
    return Bitmap.createScaledBitmap(
        bitmap,
        MAX_REC_BTMP_WIDTH,
        MAX_REC_BTMP_HEIGHT,
        false
    )
}