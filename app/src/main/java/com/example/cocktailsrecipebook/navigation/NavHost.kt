package com.example.cocktailsrecipebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cocktailsrecipebook.uilayer.FavCocktailsScreen
import com.example.cocktailsrecipebook.uilayer.RecipeScreen
import com.example.cocktailsrecipebook.uilayer.FavCocktailsVM
import com.example.cocktailsrecipebook.uilayer.FoundCocktailsScreen
import com.example.cocktailsrecipebook.uilayer.SearchCocktailScreen
import com.example.cocktailsrecipebook.uilayer.SearchCocktailsVM

@Composable
fun MyNavHost(
    navController: NavHostController,
    favCocktailsVM: FavCocktailsVM,
    searchCocktailsVM: SearchCocktailsVM
) {
    NavHost(
        navController = navController,
        startDestination = NavItems.FavCocktails.path
    ) {

        composable(route = NavItems.FavCocktails.path) { FavCocktailsScreen() }
        composable(route = NavItems.FoundCocktails.path ) {
            FoundCocktailsScreen(
                searchCocktailsVM = searchCocktailsVM,
                onBack = { navController.navigate(NavItems.SearchCocktails.path) },
                navController = navController
            )
        }
        composable(route = NavItems.SearchCocktails.path ) { SearchCocktailScreen(navController = navController, searchCocktailsVM = searchCocktailsVM) }
        composable(route="cocktails/{cocktailName}") {
                backStakeEntry ->
            val cocktailName = backStakeEntry.arguments?.getString("cocktailName") ?:""
            RecipeScreen(cocktailName, favCocktailsVM)
        }
    }
}