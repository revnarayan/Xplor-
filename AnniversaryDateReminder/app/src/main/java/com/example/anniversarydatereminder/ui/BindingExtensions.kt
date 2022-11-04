package com.example.anniversarydatereminder.ui



import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("customBackground")
fun setBackground(view: View, @ColorRes resId: Int) {
    view.setBackgroundColor(ContextCompat.getColor(view.context, resId))
}
