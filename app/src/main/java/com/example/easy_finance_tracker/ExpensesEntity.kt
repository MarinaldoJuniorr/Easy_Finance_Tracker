package com.example.easy_finance_tracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index(value = ["description", "amount", "category_key"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["key"],
        childColumns = ["category_key"]
    )]
)
class ExpensesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Long = 0,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("amount")
    val amount: Long,
    @ColumnInfo("category_key")
    val categoryKey: String
)
