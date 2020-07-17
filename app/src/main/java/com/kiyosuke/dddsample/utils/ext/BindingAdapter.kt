package com.kiyosuke.dddsample.utils.ext

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter("isVisible")
    fun visible(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }
}