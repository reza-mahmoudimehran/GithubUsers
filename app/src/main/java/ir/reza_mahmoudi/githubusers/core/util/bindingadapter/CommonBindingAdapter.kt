package ir.reza_mahmoudi.githubusers.core.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import ir.reza_mahmoudi.githubusers.core.util.image.getProgressDrawable
import ir.reza_mahmoudi.githubusers.core.util.image.loadImage

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, imageUrl: String) {
    val progressDrawable = getProgressDrawable(imageView.context)
    imageView.loadImage(imageUrl, progressDrawable)
}