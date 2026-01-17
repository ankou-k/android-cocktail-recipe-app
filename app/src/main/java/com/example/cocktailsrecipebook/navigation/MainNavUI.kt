package com.example.cocktailsrecipebook.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cocktailsrecipebook.uilayer.FavCocktailsVM
import com.example.cocktailsrecipebook.uilayer.SearchCocktailsVM

/**
 * Main composable UI for the entire application.
 *
 * This composable sets up the app's scaffold structure:
 * - Bottom navigation bar for switching between screens
 * - Navigation host responsible for displaying different screens
 *
 * This composable is the root of the UI hierarchy and coordinates
 * all major UI components and ViewModels.
 */
@Composable
fun MainNavUI(
    favCocktailsVM: FavCocktailsVM,
    searchCocktailsVM: SearchCocktailsVM
) {
    // Create navigation controller to manage screen navigation
    // rememberNavController ensures it survives recomposition
    val navController = rememberNavController()

    // Scaffold provides the basic Material Design structure
    Scaffold(
        // Bottom navigation bar for switching between main screens
        bottomBar = {
            MyBottomBar(navController = navController)
        }
    ) { innerPadding ->
        // Main content area that fills the space between scaffold components
        Column(
            modifier = Modifier
                .padding(innerPadding)  // Respect scaffold padding (top/bottom bars)
                .fillMaxSize(),          // Take up all available space
            verticalArrangement = Arrangement.SpaceBetween  // Space items evenly
        ) {
            // Navigation host manages which screen is currently displayed
            // Pass all ViewModels so individual screens can access the data they need
            MyNavHost(
                navController = navController,
                favCocktailsVM = favCocktailsVM,
                searchCocktailsVM = searchCocktailsVM
            )
        }
    }
}