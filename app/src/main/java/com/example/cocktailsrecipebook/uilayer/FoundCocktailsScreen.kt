package com.example.cocktailsrecipebook.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cocktailsrecipebook.navigation.MyTopBarNavBack
import com.example.cocktailsrecipebook.uilayer.components.FoundCocktailCard

@Composable
fun FoundCocktailsScreen(
    searchCocktailsVM: SearchCocktailsVM,
    onBack: () -> Unit,
    navController: NavController
) {
    Scaffold(
        // Bottom navigation bar for switching between main screens
        topBar = {
            MyTopBarNavBack(onBack = onBack)
        },
    ) { innerPadding ->
        // Main content area that fills the space between scaffold components
        Column(
            modifier = Modifier
                .padding(innerPadding)  // Respect scaffold padding (top/bottom bars)
                .fillMaxSize(),          // Take up all available space
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(searchCocktailsVM.cocktails.value) { cocktail ->
                    FoundCocktailCard(cocktail = cocktail, navController = navController, )
                }
            }
        }
    }
}

