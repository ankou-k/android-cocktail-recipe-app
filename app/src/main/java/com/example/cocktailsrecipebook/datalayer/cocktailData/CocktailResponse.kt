package com.example.cocktailsrecipebook.datalayer.cocktailData

data class CocktailResponse(
    val name: String,
    val ingredients: List<String>,
    val instructions: String
)
