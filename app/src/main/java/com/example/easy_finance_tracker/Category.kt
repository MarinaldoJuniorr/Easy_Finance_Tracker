package com.example.easy_finance_tracker

enum class Category { FOOD, TRANSPORT, CLOTHES, HOUSE, OTHER, HEALTH, ALL }

enum class ColorTag { PINK, ORANGE, YELLOW, LIGHT_GREEN, BLUE }

fun Category.iconRes(): Int = when (this) {
    Category.FOOD -> R.drawable.ic_food
    Category.TRANSPORT -> R.drawable.ic_transport
    Category.CLOTHES -> R.drawable.ic_clothes
    Category.HOUSE -> R.drawable.ic_house
    Category.OTHER -> R.drawable.ic_other
    Category.HEALTH -> R.drawable.ic_healthy
    Category.ALL -> R.drawable.ic_all
}

fun Category.label(): String = when (this) {
    Category.FOOD -> "Alimentação"
    Category.TRANSPORT -> "Transporte"
    Category.CLOTHES -> "Roupas"
    Category.HOUSE -> "Casa"
    Category.OTHER -> "Outros"
    Category.HEALTH -> "Saúde"
    Category.ALL -> "Todas"
}



