package com.example.cocktailsrecipebook.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlin.collections.forEach

/**
 * Bottom navigation bar component for app navigation between screens.
 *
 * Creates a Material3 NavigationBar with items for different screens.
 * Highlights the currently selected item and handles navigation between screens.
 *
 */
@Composable
fun MyBottomBar(
    navController: NavHostController
) {
    // List of navigation items to display in the bottom bar
    val navItems = listOf(NavItems.FavCocktails, NavItems.SearchCocktails, NavItems.FoundCocktails)

    // Track which navigation item is currently selected
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        // Loop through each navigation item
        navItems.forEach { item ->
            NavigationBarItem(
                onClick = {
                    // Trigger navigation to the selected screen
                    navController.navigate(item.path)
                },
                // Highlight this item if it matches the selected index
                selected = currentRoute == item.path,
                // Display the item's title below the icon
                label = { Text(item.title) },
                // Display the item's icon
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title  // Use title for better accessibility
                    )
                }
            )
        }
    }
}
