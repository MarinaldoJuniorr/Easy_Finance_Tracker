package com.example.easy_finance_tracker

data class ExpenseUiData(
    val id: Long,
    val expenseDescription: String,
    val expenseAmount: Long,
    val categoryKey: String
)