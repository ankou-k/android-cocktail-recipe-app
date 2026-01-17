package com.example.cocktailsrecipebook.uilayer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cocktailsrecipebook.datalayer.roomDB.Cocktail
import com.example.cocktailsrecipebook.navigation.MyTopBarSimple

@Composable
fun FavCocktailsScreen(
    viewModel: FavCocktailsVM = viewModel()
) {
    // Collect the state from ViewModel
    val cocktails by viewModel.favoritesCocktails.collectAsState()


    // Load cocktails when screen is first displayed
    LaunchedEffect(Unit) {
        viewModel.getAllSavedCocktails()
    }

    Scaffold(
        // Bottom navigation bar for switching between main screens
        topBar = {
            MyTopBarSimple()
        },
    ) { innerPadding ->
        FavoriteCocktailsContent(
            cocktails = cocktails,
            onDeleteCocktail = { cocktail ->
                viewModel.deleteCocktail(cocktail)
            }
        )
    }
}

@Composable
fun FavoriteCocktailsContent(
    cocktails: List<Cocktail>?,
    onDeleteCocktail: (Cocktail) -> Unit
) {
    if (cocktails.isNullOrEmpty()) {
        // Show empty state
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No favorite cocktails yet")
        }
    } else {
        CocktailsList(
            cocktails = cocktails,
            onDeleteCocktail = onDeleteCocktail
        )
    }
}

@Composable
fun CocktailsList(
    cocktails: List<Cocktail>,
    onDeleteCocktail: (Cocktail) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(cocktails) { cocktail ->
            CocktailItem(
                cocktail = cocktail,
                onDeleteClick = { onDeleteCocktail(cocktail) }
            )
        }
    }
}

@Composable
fun CocktailItem(
    cocktail: Cocktail,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Cocktail name
            Text(
                text = cocktail.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Delete button
            Button(
                onClick = onDeleteClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Delete from Favourites")
            }
        }
    }
}