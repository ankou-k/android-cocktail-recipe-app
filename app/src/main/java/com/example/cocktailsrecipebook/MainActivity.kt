package com.example.cocktailsrecipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cocktailsrecipebook.navigation.MainNavUI
import com.example.cocktailsrecipebook.ui.theme.CocktailsRecipeBookTheme
import com.example.cocktailsrecipebook.uilayer.FavCocktailsVM
import com.example.cocktailsrecipebook.uilayer.SearchCocktailsVM
import dagger.hilt.android.HiltAndroidApp
import kotlin.getValue

@HiltAndroidApp
class MainActivity : ComponentActivity() {

    // Ensure proper lifecycle management of ViewModel and configuration change survival
    private val favCocktailsVM: FavCocktailsVM by viewModels()
    private val searchCocktailsVM: SearchCocktailsVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CocktailsRecipeBookTheme {
                MainNavUI(
                    favCocktailsVM = favCocktailsVM,
                    searchCocktailsVM = searchCocktailsVM
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CocktailsRecipeBookTheme {
        Greeting("Android")
    }
}
 */