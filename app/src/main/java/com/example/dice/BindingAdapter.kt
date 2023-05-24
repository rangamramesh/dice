package com.example.dice

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
    @BindingAdapter("currentDice")
    fun setImageResource(imageView: ImageView, imageResource: MutableLiveData<Int>) {
     imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context,imageResource.value?:R.drawable.empty_dice))
    }
