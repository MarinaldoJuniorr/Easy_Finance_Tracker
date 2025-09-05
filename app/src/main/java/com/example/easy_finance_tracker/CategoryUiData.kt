package com.example.easy_finance_tracker

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class CategoryUiData(
    val category: String,
    @DrawableRes val categoryIcon: Int,
    @ColorRes val color: Int,
    val isSelected: Boolean
)
