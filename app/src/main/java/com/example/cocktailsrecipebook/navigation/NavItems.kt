package com.example.cocktailsrecipebook.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search

sealed class NavItems {
    object FavCocktails : Item("home", "Home", Icons.Default.Home)
    object SearchCocktails : Item("search-cocktails", "Search Quotes", Icons.Default.Search)
    object FoundCocktails : Item("found-cocktails", "Found Quotes", Icons.AutoMirrored.Outlined.List)
    object Recipe : Item("recipe", "Recipe", Icons.Default.Build)
}