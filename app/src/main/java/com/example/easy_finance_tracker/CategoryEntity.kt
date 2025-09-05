package com.example.easy_finance_tracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CategoryEntity(
    @PrimaryKey
    @ColumnInfo("key")
    val category: Category,
    @ColumnInfo("icon")
    val icon: Int,
    @ColumnInfo("color")
    val color: Int,
    @ColumnInfo("is_selected")
    val isSelected: Boolean
)


