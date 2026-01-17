package com.example.cocktailsrecipebook.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.cocktailsrecipebook.ui.theme.Pink80

/**
 * Top navigation bar component for displaying app title and app actions.
 *
 * Creates a Material3 TopAppBar with a title and actions to manipulate display.
 *
 */

// Adding experimental opt-in because this component might become outdated soon according to documentation.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarSimple() {

    CenterAlignedTopAppBar(
        // Set title to display in Top Bar
        title = { Text("Cocktail Recipes") },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Pink80),
        // Actions are to the left of the title
        // No actions needed for this app
        actions = { }
    )
}

// Adding experimental opt-in because this component might become outdated soon according to documentation.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarNavBack(
onBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        // Set title to display in Top Bar
        title = { Text("Cocktail Recipes") },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Pink80),
        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "back")
            }
        },
        // Actions are to the left of the title
        // No actions needed for this app
        actions = { }
    )
}

