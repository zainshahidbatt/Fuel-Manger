package com.example.activity.ui.dashboard.dashboard_component

import androidx.annotation.DrawableRes
import com.example.activity.databinding.CardComponentBinding

class ButtonCardComponent(
    binding: CardComponentBinding,
    title: String,
    @DrawableRes img: Int,
) {
    init {
        binding.apply {
            tvTitle.text = title
            imgIcon.setImageResource(img)
        }
    }
}