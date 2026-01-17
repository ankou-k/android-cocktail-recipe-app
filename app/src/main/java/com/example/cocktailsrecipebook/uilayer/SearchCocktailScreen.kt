package com.example.cocktailsrecipebook.uilayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SearchCocktailScreen(
    navController: NavController,
    searchCocktailsVM: SearchCocktailsVM
) {
    var name by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Search Cocktails",
            modifier = Modifier.padding(bottom = 24.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "Name: ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )

        // TextField for user input
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Ingredients: ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )

        TextField(
            value = ingredients,
            onValueChange = { ingredients = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val result =  searchCocktailsVM.onSearchClick(name, ingredients)
            if (result) {
                navController.navigate("found-cocktails")
            }
        }) {
            Text("Search")
        }

    }
}

